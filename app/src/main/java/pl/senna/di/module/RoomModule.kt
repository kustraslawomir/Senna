package pl.senna.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import pl.senna.Application
import pl.senna.di.scopes.AppScope
import pl.senna.repository.local.AppDataBase

@Module
class RoomModule(application: Application) {

    private val localSource: AppDataBase =
            Room.databaseBuilder<AppDataBase>(application, AppDataBase::class.java, "db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @AppScope
    fun provideLocalSource() = localSource


    @Provides
    @AppScope
    fun provideUserDao(database: AppDataBase) = database.userDao()
}