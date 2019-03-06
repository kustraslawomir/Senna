package com.senna.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.senna.model.databse.Composition
import com.senna.model.databse.User
import com.senna.repository.local.converter.Converters
import com.senna.repository.local.dao.CompositionDao
import com.senna.repository.local.dao.UserDao

@Database(entities = [User::class, Composition::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun compositionDao(): CompositionDao
}
