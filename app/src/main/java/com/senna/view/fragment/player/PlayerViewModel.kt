package com.senna.view.fragment.player

import androidx.lifecycle.ViewModel
import com.senna.SennaApplication
import com.senna.usecases.player.PlayerControlUseCase
import com.senna.usecases.player.SetPlayerSoundSourceUseCase
import javax.inject.Inject

class PlayerViewModel : ViewModel() {

    @Inject lateinit var playerSourceSoundsUseCase: SetPlayerSoundSourceUseCase
    @Inject lateinit var playerControlUseCase: PlayerControlUseCase

    init {
        SennaApplication.component.inject(this)
    }

    fun setPlayerSource(sounds: List<String>) = playerSourceSoundsUseCase.setPlayerSource(sounds)

    fun play() = playerControlUseCase.resume()

    fun pause() = playerControlUseCase.pause()
}