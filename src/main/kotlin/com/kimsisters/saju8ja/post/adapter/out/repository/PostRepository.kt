package com.kimsisters.saju8ja.post.adapter.out.repository

import com.kimsisters.saju8ja.post.adapter.out.entity.CategoryJpaEntity
import com.kimsisters.saju8ja.post.adapter.out.entity.PostJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<PostJpaEntity, Long>, PostRepositoryCustom {
    fun findAllByCategory(category: CategoryJpaEntity) : List<PostJpaEntity>
}

interface PostRepositoryCustom {

}

