package com.kimsisters.saju8ja.post.adapter.`in`.model

class PostWebRequest {
    data class CreatePost(
        val title: String,
        val content: String,
        val createdBy: String,
    )

    data class SearchPost(
        val id: String?,
        val titleKeyword: String?,
    )
}
