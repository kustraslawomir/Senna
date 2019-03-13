package com.senna.usecases.player

import com.senna.player.Player
import javax.inject.Inject

class PlayerControlUseCase  @Inject constructor(val player: Player) {

    fun pause(){
        player.pause()
    }

    fun resume(){
        player.resume()
    }
}