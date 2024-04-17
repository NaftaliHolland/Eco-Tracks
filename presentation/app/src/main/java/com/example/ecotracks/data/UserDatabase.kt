package com.example.ecotracks.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ecotracks.model.User
import com.example.ecotracks.model.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}