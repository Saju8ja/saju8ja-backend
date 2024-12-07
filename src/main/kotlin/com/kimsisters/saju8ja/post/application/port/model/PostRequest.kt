package com.kimsisters.saju8ja.post.application.port.model

class PostRequest {
    data class CreatePost(
        val categoryId: String,
        val title: String,
        val content: String,
        val createdBy: String
    )
}