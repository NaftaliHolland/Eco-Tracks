package com.example.ecotracks.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ecotracks.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    suspend fun getUser(email: String, password: String): User

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun addUser(user: User)
}