package com.senna.di.module

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import com.senna.di.scopes.AppScope
import com.senna.usecases.GetPublicCompositionsUseCase
import com.senna.usecases.NavigateToMainScreenAfterDelayUseCase

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