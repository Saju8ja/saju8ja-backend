package com.kimsisters.saju8ja.post.adapter.`in`

import com.kimsisters.saju8ja.global.util.ApiResponse
import com.kimsisters.saju8ja.post.adapter.`in`.mapper.toGetPostsResponse
import com.kimsisters.saju8ja.post.adapter.`in`.model.PostWebRequest
import com.kimsisters.saju8ja.post.adapter.`in`.model.PostWebResponse
import com.kimsisters.saju8ja.post.application.port.`in`.PostUseCase
import com.kimsisters.saju8ja.post.application.port.command.PostRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController(value = "v1/categories/{category_id}/posts")
class PostController(
    private val useCase: PostUseCase,
) {
    @PostMapping
    fun create(
        @PathVariable("category_id") categoryId: String,
        @RequestBody request: PostWebRequest.CreatePost,
    ): ResponseEntity<ApiResponse<PostWebResponse.CreatePost>> {
        val input =
            PostRequest.CreatePost(
                categoryId = categoryId,
                title = request.title,
                content = request.content,
                createdBy = request.createdBy,
            )
        val output = useCase.create(input)
        return ApiResponse.okData(PostWebResponse.CreatePost(output.id))
    }

    @GetMapping
    fun getPosts(
        @PathVariable("category_id") categoryId: String
    ): ResponseEntity<ApiResponse<PostWebResponse.GetPosts>> {
        val output = useCase.getPosts(categoryId)
        return ApiResponse.okData(output.toGetPostsResponse())
    }

    @PostMapping("/search")
    fun searchPosts(
        @PathVariable("category_id") categoryId: String,
        @RequestBody request: PostWebRequest.SearchPost
    ): ResponseEntity<ApiResponse<PostWebResponse.GetPosts>> {
        val input = PostRequest.SearchPost(request.title)
        val output = useCase.searchPosts(categoryId, input)
        return ApiResponse.okData(output.toGetPostsResponse())
    }
}
