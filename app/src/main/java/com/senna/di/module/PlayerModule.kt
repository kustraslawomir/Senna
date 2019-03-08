package com.senna.di.module

import android.content.Context
import com.senna.di.scopes.AppScope
import com.senna.player.Player
import dagger.Module
import dagger.Provides

@Module
class PlayerModule(var context: Context) {

    @Provides
    @AppScope
    fun getPlayer(context: Context) : Player {
        return Player(context)
    }
}