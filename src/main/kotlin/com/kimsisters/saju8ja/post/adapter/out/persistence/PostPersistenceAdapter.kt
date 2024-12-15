package com.kimsisters.saju8ja.post.adapter.out.persistence

import com.kimsisters.saju8ja.global.annotation.PersistenceAdapter
import com.kimsisters.saju8ja.post.adapter.out.mapper.toDomainEntity
import com.kimsisters.saju8ja.post.adapter.out.mapper.toJpaEntity
import com.kimsisters.saju8ja.post.adapter.out.repository.PostRepository
import com.kimsisters.saju8ja.post.application.port.out.CreatePostPort
import com.kimsisters.saju8ja.post.application.port.out.GetPostPort
import com.kimsisters.saju8ja.post.domain.Category
import com.kimsisters.saju8ja.post.domain.Post

@PersistenceAdapter
class PostPersistenceAdapter(
    private val postRepository: PostRepository,
) : CreatePostPort, GetPostPort {
    override fun save(post: Post): Post {
        val categoryJpaEntity = post.category.toJpaEntity()
        val postJpaEntity = postRepository.save(post.toJpaEntity(categoryJpaEntity))
        return postJpaEntity.toDomainEntity()
    }

    override fun getPosts(category: Category): List<Post> {
        val categoryJpaEntity = category.toJpaEntity()
        val postJpaEntities = postRepository.findAllByCategory(categoryJpaEntity)
        return postJpaEntities.map { it.toDomainEntity() }
    }

    override fun searchPosts(category: Category, id: String?, titleKeyword: String?): List<Post> {
        TODO("Not yet implemented")
    }
}
