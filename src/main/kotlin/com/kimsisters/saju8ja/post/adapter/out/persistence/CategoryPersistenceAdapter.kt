package com.kimsisters.saju8ja.post.adapter.out.persistence

import com.kimsisters.saju8ja.global.annotation.PersistenceAdapter
import com.kimsisters.saju8ja.post.adapter.out.mapper.toDomainEntity
import com.kimsisters.saju8ja.post.adapter.out.repository.CategoryRepository
import com.kimsisters.saju8ja.post.application.port.GetCategoryPort
import com.kimsisters.saju8ja.post.domain.Category
import jakarta.transaction.SystemException
import kotlin.jvm.optionals.getOrNull

@PersistenceAdapter
class CategoryPersistenceAdapter(
    private val categoryRepository: CategoryRepository
): GetCategoryPort {
    override fun getCategory(id: String): Category {
        val categoryJpaEntity = categoryRepository.findById(id).getOrNull()
            ?: throw SystemException("")
        return categoryJpaEntity.toDomainEntity()
    }
}
