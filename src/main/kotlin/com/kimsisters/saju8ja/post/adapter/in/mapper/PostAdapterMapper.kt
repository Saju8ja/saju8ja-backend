package com.kimsisters.saju8ja.post.adapter.`in`.mapper

import com.kimsisters.saju8ja.post.adapter.`in`.model.PostWebResponse
import com.kimsisters.saju8ja.post.application.port.command.PostResponse

fun PostResponse.GetPosts.toGetPostsResponse(): PostWebResponse.GetPosts {
    val posts = this.posts.map {
        PostWebResponse.GetPosts.Post(
            id = it.id,
            title = it.title,
            createdBy = it.createdBy,
            createdAt = it.createdAt,
            views = it.views
        )
    }
    return PostWebResponse.GetPosts(posts)
}

