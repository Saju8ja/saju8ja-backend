package com.kimsisters.saju8ja.post.application.port.out

import com.kimsisters.saju8ja.post.domain.Category
import com.kimsisters.saju8ja.post.domain.Post

interface GetPostPort {
    fun getPosts(category: Category): List<Post>
    fun searchPosts(category: Category, id: String?, titleKeyword: String?): List<Post>
}
