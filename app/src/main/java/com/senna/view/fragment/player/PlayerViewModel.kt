package com.senna.view.fragment.player

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senna.SennaApplication
import com.senna.model.PlayerState
import com.senna.usecases.player.SetPlayerSoundSourceUseCase
import javax.inject.Inject

class PlayerViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var playerSourceSoundsUseCase: SetPlayerSoundSourceUseCase

    private val playerState: MutableLiveData<PlayerState> = MutableLiveData()

    init {
        SennaApplication.component.inject(this)
    }

    fun setPlayerSource(sounds: List<String>) {
        playerSourceSoundsUseCase.setPlayerSource(sounds)
    }

    fun getPlayerState() : LiveData<PlayerState> = playerState

    fun play() {
        playerState.value = PlayerState.Playing
    }

    fun pause() {
        playerState.value = PlayerState.Paused
    }
}