package com.kimsisters.saju8ja.post.domain

import com.github.f4b6a3.ulid.Ulid

class Post(
    val id: Ulid? = null,
    val category: Category,
    val title: String,
    val content: String,
    val createdBy: String,
    val createdAt: Long,
    val views: Int = 0
)
