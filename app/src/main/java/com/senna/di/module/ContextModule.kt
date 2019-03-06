package com.senna.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import com.senna.di.scopes.AppScope

@Module
class ContextModule(private val context: Context) {

    @AppScope
    @Provides
    fun provideContext() = context
}