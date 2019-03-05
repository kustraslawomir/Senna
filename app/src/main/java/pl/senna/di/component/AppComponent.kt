package pl.senna.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import pl.senna.di.module.*
import pl.senna.di.scopes.AppScope
import pl.senna.usecases.GetDefaultCompositionsUseCase
import pl.senna.usecases.NavigateToMainScreenAfterDelayUseCase
import pl.senna.view.activity.main.MainViewModel
import pl.senna.view.activity.splash.SplashViewModel
import pl.senna.view.fragment.compositions.CompositionsViewModel

@AppScope
@Component(modules =
[AndroidInjectionModule::class, BuilderModule::class, AppModule::class, ContextModule::class,
    RoomModule::class, NetworkModule::class, FireBaseDatabaseModule::class, UseCasesModule::class])

interface AppComponent {

    fun inject(viewModel: MainViewModel)

    fun inject(viewModel: SplashViewModel)

    fun inject(viewModel: CompositionsViewModel)

    fun inject(useCase: NavigateToMainScreenAfterDelayUseCase)

    fun inject(useCase: GetDefaultCompositionsUseCase)

}