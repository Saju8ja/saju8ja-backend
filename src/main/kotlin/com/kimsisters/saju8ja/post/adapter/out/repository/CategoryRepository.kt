package com.kimsisters.saju8ja.post.adapter.out.repository

import com.kimsisters.saju8ja.post.adapter.out.entity.CategoryJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<CategoryJpaEntity, String>
