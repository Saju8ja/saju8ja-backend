package com.kimsisters.saju8ja.post.adapter.`in`

import com.kimsisters.saju8ja.post.adapter.`in`.model.PostWebRequest
import com.kimsisters.saju8ja.post.adapter.`in`.model.PostWebResponse
import com.kimsisters.saju8ja.post.application.port.`in`.PostUseCase
import com.kimsisters.saju8ja.post.application.port.model.PostRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController(value = "v1/posts")
class PostController(
    private val useCase: PostUseCase,
) {
    @PostMapping
    fun create(
        @RequestBody request: PostWebRequest.CreatePost,
    ): PostWebResponse.CreatePost {
        val input =
            PostRequest.CreatePost(
                categoryId = request.categoryId,
                title = request.title,
                content = request.content,
                createdBy = request.createdBy,
            )
        val output = useCase.create(input)
        return PostWebResponse.CreatePost(output.id)
    }
}
