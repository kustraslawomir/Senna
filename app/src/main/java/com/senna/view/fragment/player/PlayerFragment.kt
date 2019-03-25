package com.senna.view.fragment.player

import android.os.Bundle
import android.view.View
import com.example.playerview.PlayerStateCallBack
import com.senna.com.R
import com.senna.model.databse.Composition
import com.senna.utils.Constants.Companion.COMPOSITION
import com.senna.view.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : BaseFragment(), PlayerStateCallBack {

    override fun getViewModel() = provideViewModel(PlayerViewModel::class.java)

    private lateinit var viewModel: PlayerViewModel

    override fun getLayoutId() = R.layout.fragment_player

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerUi.setCallback(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()

        val bundle = arguments
        if (bundle != null) {
            val composition : Composition? = bundle.getParcelable(COMPOSITION)
            if (composition != null) {
                viewModel.setPlayerSource(composition.sounds)
            }
        }
    }

    override fun pauseClick() {
        viewModel.pause()
    }

    override fun playClick() {
        viewModel.play()
    }
}