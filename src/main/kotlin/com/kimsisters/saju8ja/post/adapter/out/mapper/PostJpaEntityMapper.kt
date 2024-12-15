package com.kimsisters.saju8ja.post.adapter.out.mapper

import com.kimsisters.saju8ja.post.adapter.out.entity.CategoryJpaEntity
import com.kimsisters.saju8ja.post.adapter.out.entity.PostJpaEntity
import com.kimsisters.saju8ja.post.domain.Category
import com.kimsisters.saju8ja.post.domain.Post

fun Post.toJpaEntity(category: CategoryJpaEntity): PostJpaEntity {
    return PostJpaEntity(
        category = category,
        title = this.title,
        content = this.content,
        createdBy = this.createdBy
    )
}

fun PostJpaEntity.toDomainEntity(): Post {
    return Post(
        id,
        category.toDomainEntity(),
        title,
        content,
        createdBy,
        createdAt,
        views
    )
}

fun Category.toJpaEntity(): CategoryJpaEntity {
    return CategoryJpaEntity(
        parentCategory = this.toJpaEntity(),
        name = this.name,
        isAnonymous = this.isAnonymous,
        order = this.order
    )
}

fun CategoryJpaEntity.toDomainEntity(): Category {
    return Category(
        id.toString(),
        parent?.toDomainEntity(),
        name,
        isAnonymous,
        order
    )
}
