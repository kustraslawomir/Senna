package pl.senna.di.module

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import pl.senna.di.scopes.AppScope
import pl.senna.usecases.GetPublicCompositionsUseCase
import pl.senna.usecases.NavigateToMainScreenAfterDelayUseCase

@Module(includes = [FireBaseDatabaseModule::class])
class UseCasesModule {

    @Provides
    @AppScope
    fun getDefaultCompositionsUseCase(fireBaseDatabase: FirebaseDatabase): GetPublicCompositionsUseCase {
        return GetPublicCompositionsUseCase(fireBaseDatabase)
    }

    @Provides
    @AppScope
    fun getNavigateToMainScreenAfterDelayUseCase(): NavigateToMainScreenAfterDelayUseCase{
        return NavigateToMainScreenAfterDelayUseCase()
    }
}