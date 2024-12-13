package com.kimsisters.saju8ja.post.adapter.`in`.model

class PostWebResponse {
    data class CreatePost(
        val id: String,
    )

    data class GetPosts(
        val posts: List<Post>
    ) {
        data class Post(
            val id: String,
            val title: String,
            val createdBy: String?,
            val createdAt: Long,
            val views: Int
        )
    }
}
