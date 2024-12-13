package com.kimsisters.saju8ja.post.application.port.`in`

import com.kimsisters.saju8ja.post.application.port.command.PostRequest
import com.kimsisters.saju8ja.post.application.port.command.PostResponse
import org.springframework.stereotype.Component

@Component
interface PostUseCase {
    fun create(command: PostRequest.CreatePost): PostResponse.Post
    fun getPosts(categoryId: String): PostResponse.GetPosts
    fun searchPosts(categoryId: String, command: PostRequest.SearchPost): PostResponse.GetPosts
}
