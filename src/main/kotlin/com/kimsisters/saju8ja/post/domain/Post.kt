package com.kimsisters.saju8ja.post.domain

import java.util.*

class Post(
    val id: UUID? = null,
    val category: Category,
    val title: String,
    val content: String,
    val createdBy: String,
    val createdAt: Long,
    val views: Int = 0
)
