package com.senna.utils.customview.playerview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.senna.com.R
import kotlinx.android.synthetic.main.controls_ui.view.*
import com.senna.utils.customview.playerview.utils.PlayerConstants.Companion.PAUSE
import com.senna.utils.customview.playerview.utils.PlayerConstants.Companion.RESUME
import kotlin.properties.Delegates

open class PlayerView : FrameLayout {

    private lateinit var vinylView: VinylView
    private var callback: PlayerStateCallBack? = null

    private var playerState: Int by Delegates.observable(PAUSE) { _, _, new -> handlePlayerStateChange(new) }

    private fun handlePlayerStateChange(state: Int) {
        println("player state: $state")
        when (state) {
            PAUSE -> {
                vinylView.pausePlayerUi()
                mediaControl.setImageResource(R.drawable.ic_ico_play)
            }
            RESUME -> {
                vinylView.resumePlayerUi()
                mediaControl.setImageResource(R.drawable.ic_pause_button)
            }
        }
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
            context,
            attributeSet,
            defStyleAttr
    ) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        inflate(context, R.layout.controls_ui, this)

        vinylView = VinylView(context)
        vinylView.setBackgroundColor(Color.parseColor("#00000000"))
        addView(vinylView)

        var shouldDrawPlayerControls = true

        if (attributeSet != null) {
            val typedArray = context.theme.obtainStyledAttributes(attributeSet, R.styleable.PlayerView, 0, 0)
            shouldDrawPlayerControls = typedArray.getBoolean(R.styleable.PlayerView_player_visible, true)
            Log.d("PlayerView", "shouldDrawPlayerControls $shouldDrawPlayerControls")
        }

        val starsView = StarsView(context)
        starsView.setBackgroundColor(Color.parseColor("#00000000"))
        addView(starsView)

        if (!shouldDrawPlayerControls)
            controls.visibility = View.GONE

        mediaControl.setOnClickListener {
            if (playerState == RESUME)
                pausePlayerUi()
            else resumePlayerUi()
        }
    }

    fun setCallback(callback: PlayerStateCallBack) {
        this.callback = callback
    }

    fun resumePlayerUi() {
        if (callback != null) {
            playerState = RESUME
            callback?.playClick()
        }
    }

    fun pausePlayerUi() {
        if (callback != null) {
            playerState = PAUSE
            callback?.pauseClick()
        }
    }
}