package com.kimsisters.saju8ja.post.adapter.`in`

import com.kimsisters.saju8ja.post.adapter.`in`.model.PostWebRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController(value = "v1/posts")
class PostController {
    @PostMapping
    fun create(
        @RequestBody request: PostWebRequest.CreatePost
    ) {

    }
}
