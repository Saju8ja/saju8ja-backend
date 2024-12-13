package com.kimsisters.saju8ja.post.application.port.command

class PostResponse {
    data class Post(
        val id: String,
    )

    data class GetPosts(
        val posts: List<Post>
    ) {
        data class Post(
            val categoryId: String,
            val id: String,
            val title: String,
            val content: String,
            val createdBy: String?,
            val createdAt: Long,
            val views: Int
        )
    }
}
