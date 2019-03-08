package com.senna.di.module

import androidx.room.Room
import com.senna.SennaApplication
import com.senna.di.scopes.AppScope
import com.senna.repository.local.DataBase
import dagger.Module
import dagger.Provides

@Module
class RoomModule(application: SennaApplication) {

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

    @Provides
    @AppScope
    fun provideCompositionDao(database: DataBase) = database.compositionDao()
}