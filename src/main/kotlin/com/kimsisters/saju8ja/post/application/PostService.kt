package com.kimsisters.saju8ja.post.application

import com.kimsisters.saju8ja.post.application.port.`in`.PostUseCase
import com.kimsisters.saju8ja.post.application.port.model.PostRequest
import com.kimsisters.saju8ja.post.application.port.model.PostResponse

class PostService : PostUseCase {
    override fun create(post: PostRequest.CreatePost) : PostResponse.Post {
        TODO("Not yet implemented")
    }
}
