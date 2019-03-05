package pl.senna

import android.app.Application
import com.facebook.stetho.Stetho
import pl.senna.di.component.AppComponent
import pl.senna.di.component.DaggerAppComponent
import pl.senna.di.module.AppModule
import pl.senna.di.module.ContextModule
import pl.senna.di.module.RoomModule
import timber.log.Timber

class Application : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(applicationContext))
                .appModule(AppModule(this))
                .roomModule(RoomModule(this)).build()
    }
}