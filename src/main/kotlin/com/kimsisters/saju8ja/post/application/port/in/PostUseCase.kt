package com.kimsisters.saju8ja.post.application.port.`in`

import com.kimsisters.saju8ja.post.application.port.model.PostRequest
import com.kimsisters.saju8ja.post.application.port.model.PostResponse
import org.springframework.stereotype.Component

@Component
interface PostUseCase {
    fun create(input: PostRequest.CreatePost): PostResponse.Post
}
