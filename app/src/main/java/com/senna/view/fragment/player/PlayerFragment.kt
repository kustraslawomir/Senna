package com.senna.view.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.senna.com.R
import com.senna.model.databse.Composition
import com.senna.utils.Constants.Companion.COMPOSITION
import com.senna.utils.extensions.setLifeCycleObserver
import kotlinx.android.synthetic.main.fragment_player.*
import slawomir.kustra.starrysky.PlayerStateCallBack

class PlayerFragment : Fragment(), PlayerStateCallBack {

    private lateinit var viewModel: PlayerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View = inflater.inflate(R.layout.fragment_player, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)
        setLifeCycleObserver(viewModel)
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