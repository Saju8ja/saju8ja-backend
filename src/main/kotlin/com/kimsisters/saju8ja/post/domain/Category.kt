package com.kimsisters.saju8ja.post.domain

class Category(
    val id: String,
    val parentCategory: Category?,
    val name: String,
    val isAnonymous: Boolean,
    val order: Int,
) {
    constructor(id: String, name: String, isAnonymous: Boolean, order: Int) :
        this(id, null, name, isAnonymous, order)
}
