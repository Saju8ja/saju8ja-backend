package com.kimsisters.saju8ja.post.application.port.`in`

import com.kimsisters.saju8ja.post.application.port.model.PostRequest
import com.kimsisters.saju8ja.post.application.port.model.PostResponse

interface PostUseCase {
    fun create(post: PostRequest.CreatePost) : PostResponse.Post
}
