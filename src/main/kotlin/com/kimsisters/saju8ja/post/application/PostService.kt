package com.kimsisters.saju8ja.post.application

import com.kimsisters.saju8ja.post.application.port.GetCategoryPort
import com.kimsisters.saju8ja.post.application.port.`in`.PostUseCase
import com.kimsisters.saju8ja.post.application.port.model.PostRequest
import com.kimsisters.saju8ja.post.application.port.model.PostResponse
import com.kimsisters.saju8ja.post.application.port.out.CreatePostPort
import com.kimsisters.saju8ja.post.domain.Post
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset

class PostService(
    private val getCategoryPort: GetCategoryPort,
    private val createPort: CreatePostPort,
) : PostUseCase {
    override fun create(input: PostRequest.CreatePost): PostResponse.Post {
        val category = getCategoryPort.getCategory(input.categoryId)
        val post =
            Post(
                category = category,
                title = input.title,
                content = input.content,
                createdBy = input.createdBy,
                createdAt = LocalDate.now().toEpochSecond(LocalTime.now(), ZoneOffset.UTC),
            )
        return PostResponse.Post(createPort.save(post).id.toString())
    }
}
