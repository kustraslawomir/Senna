package com.senna.view.fragment.player

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.playerview.PlayerStateCallBack
import com.senna.com.R
import com.senna.model.databse.Composition
import com.senna.utils.Constants.Companion.COMPOSITION
import com.senna.view.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : BaseFragment(), PlayerStateCallBack {

    override fun getViewModel() = ViewModelProviders.of(this).get(PlayerViewModel::class.java)

    private lateinit var viewModel: PlayerViewModel

    override fun getLayoutId() = R.layout.fragment_player

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getViewModel()
        playerUi.setCallback(this)

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