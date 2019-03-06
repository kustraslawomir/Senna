package com.senna.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senna.model.databse.User
import com.senna.repository.local.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
