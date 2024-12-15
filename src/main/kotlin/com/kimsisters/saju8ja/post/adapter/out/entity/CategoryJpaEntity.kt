package com.kimsisters.saju8ja.post.adapter.out.entity

import com.kimsisters.saju8ja.global.entity.PrimaryKeyEntity
import jakarta.persistence.*

@Entity
@Table(name = "category")
class CategoryJpaEntity(
    name: String,
    parentCategory: CategoryJpaEntity?,
    isAnonymous: Boolean?,
    order: Int
) : PrimaryKeyEntity() {
    @Column(nullable = false, unique = true)
    var name: String = name
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: CategoryJpaEntity? = parentCategory

    @Column(nullable = false)
    val isAnonymous: Boolean = isAnonymous ?: false

    @Column(nullable = false)
    val order: Int = order

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL], orphanRemoval = true)
    val children: MutableList<CategoryJpaEntity> = mutableListOf()

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
    val posts: MutableList<PostJpaEntity> = mutableListOf()
}
