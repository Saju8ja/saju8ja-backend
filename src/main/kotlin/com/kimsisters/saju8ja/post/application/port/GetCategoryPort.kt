package com.kimsisters.saju8ja.post.application.port

import com.kimsisters.saju8ja.post.domain.Category

interface GetCategoryPort {
    fun getCategory(id: String) : Category
}
