package com.senna

import android.app.Application
import com.facebook.stetho.Stetho
import com.senna.di.component.AppComponent
import com.senna.di.component.DaggerAppComponent
import com.senna.di.module.AppModule
import com.senna.di.module.ContextModule
import com.senna.di.module.RoomModule
import timber.log.Timber

class Application : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }

    private fun initializeDagger() {
        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .appModule(AppModule(this))
                .roomModule(RoomModule(this)).build()
    }
}