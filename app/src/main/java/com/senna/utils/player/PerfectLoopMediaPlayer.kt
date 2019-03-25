package com.senna.utils.player

import android.content.Context
import android.media.MediaPlayer
import com.senna.utils.extensions.isNotNullAndTrue
import timber.log.Timber

import java.io.IOException

class PerfectLoopMediaPlayer internal constructor(val context: Context, private val resId: Int) {

    private var currentPlayer: MediaPlayer? = null
    private var nextPlayer: MediaPlayer? = null

    private val onCompletionListener = MediaPlayer.OnCompletionListener { mediaPlayer ->
        currentPlayer = nextPlayer
        createNextMediaPlayerRaw()
        mediaPlayer.release()
    }

    init {
        try {
            val afd = context.resources.openRawResourceFd(this.resId)
            currentPlayer = MediaPlayer()
            currentPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
            currentPlayer?.prepareAsync()
            createNextMediaPlayerRaw()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    val isPlaying: Boolean
        @Throws(IllegalStateException::class)
        get() = if (currentPlayer != null) {
            currentPlayer?.isPlaying.isNotNullAndTrue()
        } else {
            false
        }

    private fun createNextMediaPlayerRaw() {
        val afd = context?.resources?.openRawResourceFd(resId)
        nextPlayer = MediaPlayer()
        try {
            if (afd != null) {
                nextPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                nextPlayer?.setOnPreparedListener {
                    nextPlayer?.seekTo(0)
                    currentPlayer?.setNextMediaPlayer(nextPlayer)
                    currentPlayer?.setOnCompletionListener(onCompletionListener)
                }
                nextPlayer?.prepareAsync()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun setVolume(leftVolume: Float, rightVolume: Float) {
        if (currentPlayer != null) {
            currentPlayer?.setVolume(leftVolume, rightVolume)
        } else {
            Timber.d("setVolume()")
        }
    }

    @Throws(IllegalStateException::class)
    fun start() {
        if (currentPlayer != null) {
            Timber.d("start()")
            currentPlayer?.start()
        } else {
            Timber.d("start() | currentPlayer is NULL")
        }

    }

    @Throws(IllegalStateException::class)
    fun stop() {
        if (currentPlayer != null && currentPlayer?.isPlaying.isNotNullAndTrue()) {
            Timber.d("stop()")
            currentPlayer?.stop()
        } else {
            Timber.d("stop() | currentPlayer is NULL or not playing")
        }

    }

    @Throws(IllegalStateException::class)
    fun pause() {
        if (currentPlayer != null && currentPlayer?.isPlaying.isNotNullAndTrue()) {
            Timber.d("pause()")
            currentPlayer?.pause()
        } else {
            Timber.d("pause() | currentPlayer is NULL or not playing")
        }
    }

    fun setWakeMode(c: Context, mode: Int) {
        if (currentPlayer != null) {
            currentPlayer?.setWakeMode(c, mode)
            Timber.d("setWakeMode() | ")
        } else {
            Timber.d("setWakeMode() | currentPlayer is NULL")
        }
    }

    fun setAudioStreamType(audioStreamType: Int) {
        if (currentPlayer != null) {
            currentPlayer?.setAudioStreamType(audioStreamType)
        } else {
            Timber.d("setAudioStreamType() | currentPlayer is NULL")
        }
    }

    fun release() {
        Timber.d("release()")
        if (currentPlayer != null)
            currentPlayer?.release()
        if (nextPlayer != null)
            nextPlayer?.release()
    }

    fun reset() {
        if (currentPlayer != null) {
            Timber.d("reset()")
            currentPlayer?.reset()
        } else {
            Timber.d("reset() | currentPlayer is NULL")
        }
    }

    companion object {
        fun create(context: Context, resId: Int): PerfectLoopMediaPlayer {
            return PerfectLoopMediaPlayer(context, resId)
        }
    }

}