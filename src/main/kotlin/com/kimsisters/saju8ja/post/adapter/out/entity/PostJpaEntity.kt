package com.kimsisters.saju8ja.post.adapter.out.entity

import com.kimsisters.saju8ja.global.entity.PrimaryKeyEntity
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset

@Entity
@Table(name = "post")
class PostJpaEntity(
    category: CategoryJpaEntity,
    title: String,
    content: String,
    createdBy: String,
) : PrimaryKeyEntity() {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    val category: CategoryJpaEntity = category

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(nullable = false)
    var content: String = content
        protected set

    @Column(nullable = false)
    val createdBy: String = createdBy

    @Column(nullable = false)
    val createdAt: Long = LocalDate.now().toEpochSecond(LocalTime.now(), ZoneOffset.UTC)

    @Column(nullable = false)
    var views: Int = 0
        protected set
}
