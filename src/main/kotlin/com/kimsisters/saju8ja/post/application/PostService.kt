package com.kimsisters.saju8ja.post.application

import com.kimsisters.saju8ja.post.application.mapper.toGetPostsPortMapper
import com.kimsisters.saju8ja.post.application.port.GetCategoryPort
import com.kimsisters.saju8ja.post.application.port.`in`.PostUseCase
import com.kimsisters.saju8ja.post.application.port.command.PostRequest
import com.kimsisters.saju8ja.post.application.port.command.PostResponse
import com.kimsisters.saju8ja.post.application.port.out.CreatePostPort
import com.kimsisters.saju8ja.post.application.port.out.GetPostPort
import com.kimsisters.saju8ja.post.domain.Post
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset

class PostService(
    private val getCategoryPort: GetCategoryPort,
    private val createPort: CreatePostPort,
    private val getPort: GetPostPort,
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

    override fun getPosts(categoryId: String): PostResponse.GetPosts {
        val category = getCategoryPort.getCategory(categoryId)
        val posts = getPort.getPosts(category)
        return posts.toGetPostsPortMapper()
    }
}
