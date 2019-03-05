package pl.senna.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import pl.senna.di.module.*
import pl.senna.di.scopes.AppScope
import pl.senna.view.activity.main.MainViewModel
import pl.senna.view.activity.splash.SplashViewModel

@AppScope
@Component(modules =
[AndroidInjectionModule::class, BuilderModule::class, AppModule::class, ContextModule::class, RoomModule::class, NetworkModule::class])

interface AppComponent {

    fun inject(mainViewModel: MainViewModel)

    fun inject(splashViewModel: SplashViewModel)

}