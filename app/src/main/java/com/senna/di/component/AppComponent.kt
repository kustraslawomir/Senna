package com.senna.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import com.senna.di.module.*
import com.senna.di.scopes.AppScope
import com.senna.usecases.compositions.FetchPublicCompositionsUseCase
import com.senna.usecases.delays.SplashDelayUseCase
import com.senna.view.activity.main.MainViewModel
import com.senna.view.activity.splash.SplashViewModel
import com.senna.view.fragment.compositions.CompositionsViewModel

@AppScope
@Component(modules =
[AndroidInjectionModule::class, BuilderModule::class, AppModule::class, ContextModule::class,
    RoomModule::class, NetworkModule::class, FireBaseDatabaseModule::class, UseCasesModule::class])

interface AppComponent {

    fun inject(viewModel: MainViewModel)

    fun inject(viewModel: SplashViewModel)

    fun inject(viewModel: CompositionsViewModel)

    fun inject(useCase: SplashDelayUseCase)

    fun inject(useCase: FetchPublicCompositionsUseCase)

}