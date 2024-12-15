package com.kimsisters.saju8ja.post.application.port.out

import com.kimsisters.saju8ja.post.domain.Post

interface CreatePostPort {
    fun save(post: Post): Post
}
