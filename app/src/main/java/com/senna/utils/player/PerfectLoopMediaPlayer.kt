package com.senna.utils.player

import android.content.Context
import android.media.MediaPlayer
import com.senna.utils.extensions.isTrue
import timber.log.Timber

import java.io.IOException

class PerfectLoopMediaPlayer internal constructor(context: Context, resId: Int) {

    private var mContext: Context? = context
    private var mResId = resId

    private var mCurrentPlayer: MediaPlayer? = null
    private var mNextPlayer: MediaPlayer? = null

    private val onCompletionListener = MediaPlayer.OnCompletionListener { mediaPlayer ->
        mCurrentPlayer = mNextPlayer
        createNextMediaPlayerRaw()
        mediaPlayer.release()
    }

    val isPlaying: Boolean
        @Throws(IllegalStateException::class)
        get() = if (mCurrentPlayer != null) {
            mCurrentPlayer?.isPlaying.isTrue()
        } else {
            false
        }

    init {
        try {
            val afd = context.resources.openRawResourceFd(mResId)
            mCurrentPlayer = MediaPlayer()
            mCurrentPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
            mCurrentPlayer?.setOnPreparedListener { mCurrentPlayer?.start() }
            mCurrentPlayer?.prepareAsync()
            createNextMediaPlayerRaw()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun createNextMediaPlayerRaw() {
        val afd = mContext?.resources?.openRawResourceFd(mResId)
        mNextPlayer = MediaPlayer()
        try {
            if (afd != null) {
                mNextPlayer?.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                mNextPlayer?.setOnPreparedListener {
                    mNextPlayer?.seekTo(0)
                    mCurrentPlayer?.setNextMediaPlayer(mNextPlayer)
                    mCurrentPlayer?.setOnCompletionListener(onCompletionListener)
                }
                mNextPlayer?.prepareAsync()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun setVolume(leftVolume: Float, rightVolume: Float) {
        if (mCurrentPlayer != null) {
            mCurrentPlayer?.setVolume(leftVolume, rightVolume)
        } else {
            Timber.d(TAG, "setVolume()")
        }
    }

    @Throws(IllegalStateException::class)
    fun start() {
        if (mCurrentPlayer != null) {
            Timber.d(TAG, "start()")
            mCurrentPlayer?.start()
        } else {
            Timber.d(TAG, "start() | mCurrentPlayer is NULL")
        }

    }

    @Throws(IllegalStateException::class)
    fun stop() {
        if (mCurrentPlayer != null && mCurrentPlayer?.isPlaying.isTrue()) {
            Timber.d(TAG, "stop()")
            mCurrentPlayer?.stop()
        } else {
            Timber.d(TAG, "stop() | mCurrentPlayer is NULL or not playing")
        }

    }

    @Throws(IllegalStateException::class)
    fun pause() {
        if (mCurrentPlayer != null && mCurrentPlayer?.isPlaying.isTrue()) {
            Timber.d(TAG, "pause()")
            mCurrentPlayer?.pause()
        } else {
            Timber.d(TAG, "pause() | mCurrentPlayer is NULL or not playing")
        }

    }

    fun setWakeMode(c: Context, mode: Int) {
        if (mCurrentPlayer != null) {
            mCurrentPlayer?.setWakeMode(c, mode)
            Timber.d(TAG, "setWakeMode() | ")
        } else {
            Timber.d(TAG, "setWakeMode() | mCurrentPlayer is NULL")
        }
    }

    fun setAudioStreamType(audioStreamType: Int) {
        if (mCurrentPlayer != null) {
            mCurrentPlayer?.setAudioStreamType(audioStreamType)
        } else {
            Timber.d(TAG, "setAudioStreamType() | mCurrentPlayer is NULL")
        }
    }

    fun release() {
        Timber.d(TAG, "release()")
        if (mCurrentPlayer != null)
            mCurrentPlayer?.release()
        if (mNextPlayer != null)
            mNextPlayer?.release()
    }

    fun reset() {
        if (mCurrentPlayer != null) {
            Timber.d(TAG, "reset()")
            mCurrentPlayer?.reset()
        } else {
            Timber.d(TAG, "reset() | mCurrentPlayer is NULL")
        }
    }

    companion object {

        private val TAG = PerfectLoopMediaPlayer::class.java.name

        fun create(context: Context, resId: Int): PerfectLoopMediaPlayer {
            return PerfectLoopMediaPlayer(context, resId)
        }
    }

}