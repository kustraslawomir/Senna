package com.senna.player

import android.content.Context
import com.senna.utils.player.PerfectLoopMediaPlayer
import timber.log.Timber
import javax.inject.Inject

class Player @Inject constructor(val context: Context) {

    private var players: MutableList<PerfectLoopMediaPlayer> = arrayListOf()

    fun setSounds(sounds: List<String>) {

        clearPlayers()

        sounds.forEach { sound ->
            Timber.d("Add media player to list for sound: %s", sound)
            players.add(PerfectLoopMediaPlayer(context, findSoundId(sound.replace(".mp3", ""))))
        }
    }

    private fun findSoundId(sound: String) = context.resources.getIdentifier(sound, "raw", context.packageName)

    private fun clearPlayers() {
        players.forEach { player ->
            player.release()
        }
        players.clear()
    }

    fun pause() {
        players.forEach { player ->
            player.pause()
        }
    }

    fun resume() {
        players.forEach { player ->
            player.start()
        }
    }
}
