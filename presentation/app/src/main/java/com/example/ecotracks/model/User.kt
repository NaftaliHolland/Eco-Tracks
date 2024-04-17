package com.example.ecotracks.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
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

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "points") val points: Int? = 0

)
