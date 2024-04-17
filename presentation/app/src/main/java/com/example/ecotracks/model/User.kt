package com.example.ecotracks.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
data class Post (
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val body: String = ""
    //@SerialName("userId") val userId: Int,
    //@SerialName("id") val id: Int,
    //@SerialName("title") val title: String,
    //@SerialName("body") val body: String
    //var name: String,
    //var email: String,
    //var password: String,
    //var createdAt: String? = null
    //var updatedAt: String? = null
    //var pointsEarned: Int? = 0
)

data class User (
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val created_at: String = "",
    val updated_at: String = "",
    val points_earned: Int = 0
)
