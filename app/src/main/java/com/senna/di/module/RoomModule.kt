package com.senna.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.senna.Application
import com.senna.di.scopes.AppScope
import com.senna.repository.local.DataBase

@Module
class RoomModule(application: Application) {

    private val localSource: DataBase =
            Room.databaseBuilder<DataBase>(application, DataBase::class.java, "db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @AppScope
    fun provideLocalSource() = localSource


    @Provides
    @AppScope
    fun provideUserDao(database: DataBase) = database.userDao()
}