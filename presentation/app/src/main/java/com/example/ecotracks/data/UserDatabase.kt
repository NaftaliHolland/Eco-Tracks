package com.example.ecotracks.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ecotracks.model.User
import com.example.ecotracks.model.UserDao
import com.example.ecotracks.data.UserDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

fun getDatabase(context: Context): UserDatabase {
    return Room.databaseBuilder(
        context,
        UserDatabase::class.java, name = "eco_tracks_db"
    ).build()
}