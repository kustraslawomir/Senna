package com.senna.di.module

import android.content.Context
import com.senna.SennaApplication
import com.senna.di.scopes.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: SennaApplication) {

    @Provides
    @AppScope
    fun provideContext() : Context = application

}