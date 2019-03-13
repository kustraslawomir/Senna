package com.senna.di.component

import com.senna.di.module.*
import com.senna.di.scopes.AppScope
import com.senna.usecases.compositions.FetchPublicCompositionsUseCase
import com.senna.usecases.delays.SplashDelayUseCase
import com.senna.usecases.player.PlayerControlUseCase
import com.senna.usecases.player.SetPlayerSoundSourceUseCase
import com.senna.view.activity.splash.SplashViewModel
import com.senna.view.fragment.compositions.CompositionsViewModel
import com.senna.view.fragment.player.PlayerViewModel
import dagger.Component
import dagger.android.AndroidInjectionModule
@AppScope
@Component(modules =
[AndroidInjectionModule::class, BuilderModule::class, AppModule::class,
    RoomModule::class, NetworkModule::class, FireBaseDatabaseModule::class, UseCasesModule::class, PlayerModule::class])

interface AppComponent {

    fun inject(viewModel: SplashViewModel)

    fun inject(viewModel: CompositionsViewModel)

    fun inject(viewModel: PlayerViewModel)

    fun inject(useCase: SplashDelayUseCase)

    fun inject(useCase: FetchPublicCompositionsUseCase)

    fun inject(useCase: SetPlayerSoundSourceUseCase)

    fun inject(useCase: PlayerControlUseCase)
}

