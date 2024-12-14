package com.kimsisters.saju8ja.post.application.port.command

class PostRequest {
    data class CreatePost(
        val categoryId: String,
        val title: String,
        val content: String,
        val createdBy: String,
    )

    data class SearchPost(
        val id: String?,
        val titleKeyword: String?
    )
}
