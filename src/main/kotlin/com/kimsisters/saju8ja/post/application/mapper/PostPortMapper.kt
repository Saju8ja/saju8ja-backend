package com.kimsisters.saju8ja.post.application.mapper

import com.kimsisters.saju8ja.post.application.port.command.PostResponse
import com.kimsisters.saju8ja.post.domain.Post

fun List<Post>.toGetPostsPortMapper(): PostResponse.GetPosts {
    val posts = this.map {
        PostResponse.GetPosts.Post(
            categoryId = it.category.id,
            id = it.id.toString(),
            title = it.title,
            content = it.content,
            createdBy = if (it.category.isAnonymous) null else it.createdBy,
            createdAt = it.createdAt,
            views = it.views
        )
    }
    return PostResponse.GetPosts(posts)
}
