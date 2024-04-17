package com.example.ecotracks.model

import com.example.ecotracks.model.Post
data class MainState(
    val posts: List<Post> = emptyList()
)
