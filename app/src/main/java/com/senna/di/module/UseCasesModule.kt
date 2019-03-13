package com.senna.di.module

import com.google.firebase.database.FirebaseDatabase
import com.senna.di.scopes.AppScope
import com.senna.player.Player
import com.senna.usecases.compositions.FetchPublicCompositionsUseCase
import com.senna.usecases.delays.SplashDelayUseCase
import com.senna.usecases.player.PlayerControlUseCase
import com.senna.usecases.player.SetPlayerSoundSourceUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [FireBaseDatabaseModule::class, PlayerModule::class])
class UseCasesModule {

    @Provides
    @AppScope
    fun getDefaultCompositionsUseCase(fireBaseDatabase: FirebaseDatabase): FetchPublicCompositionsUseCase {
        return FetchPublicCompositionsUseCase(fireBaseDatabase)
    }

    @Provides
    @AppScope
    fun getNavigateToMainScreenAfterDelayUseCase(): SplashDelayUseCase {
        return SplashDelayUseCase()
    }

    @Provides
    @AppScope
    fun getPlayerSourceSoundsUseCase(player : Player): SetPlayerSoundSourceUseCase {
        return SetPlayerSoundSourceUseCase(player)
    }

    @Provides
    @AppScope
    fun getPlayerControlUseCase(player : Player): PlayerControlUseCase {
        return PlayerControlUseCase(player)
    }
}