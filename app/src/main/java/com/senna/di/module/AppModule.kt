package com.senna.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import com.senna.Application
import com.senna.di.scopes.AppScope

@Module
class AppModule(private val application: Application) {

    @Provides
    @AppScope
    fun provideContext() : Context = application

}