package com.senna.di.module

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import com.senna.di.scopes.AppScope
import com.senna.usecases.FetchPublicCompositionsUseCase
import com.senna.usecases.NavigateToMainScreenAfterDelayUseCase

@Module(includes = [FireBaseDatabaseModule::class])
class UseCasesModule {

    @Provides
    @AppScope
    fun getDefaultCompositionsUseCase(fireBaseDatabase: FirebaseDatabase): FetchPublicCompositionsUseCase {
        return FetchPublicCompositionsUseCase(fireBaseDatabase)
    }

    @Provides
    @AppScope
    fun getNavigateToMainScreenAfterDelayUseCase(): NavigateToMainScreenAfterDelayUseCase{
        return NavigateToMainScreenAfterDelayUseCase()
    }
}