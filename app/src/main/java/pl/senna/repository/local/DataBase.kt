package pl.senna.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.senna.model.databse.User
import pl.senna.repository.local.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
