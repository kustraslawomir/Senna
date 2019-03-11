package com.senna.usecases.player

import com.senna.player.Player
import javax.inject.Inject

class SetPlayerSoundSourceUseCase @Inject constructor(val player: Player) {

   fun setPlayerSource(sounds : List<String>){
       player.setSounds(sounds)
               //test 
   }
}