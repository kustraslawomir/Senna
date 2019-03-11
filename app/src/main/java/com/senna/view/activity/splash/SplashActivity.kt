package com.senna.view.activity.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.senna.com.R
import com.senna.model.fetchstates.GetCompositionsNetworkState
import com.senna.utils.extensions.*
import com.senna.view.activity.BaseActivity
import com.senna.view.activity.nagivation.NavigationActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        observeNavigationEvent(viewModel)
        observeNetworkState(viewModel)
    }

    private fun observeNetworkState(viewModel: SplashViewModel) {
        viewModel.getFetchingStatus().listen(this) { fetchingStatus ->
            hideProgressBar()
            when (fetchingStatus) {
                is GetCompositionsNetworkState.Loading -> showProgressBar()
                is GetCompositionsNetworkState.Error -> showError(fetchingStatus.errorMessage)
            }
        }
    }

    private fun observeNavigationEvent(viewModel: SplashViewModel) {
        viewModel.getNavigateToMainScreenEvent().listen(this) { navigateToMain ->
            if (navigateToMain.shouldBeHandled().isTrue())
                replaceActivity(NavigationActivity::class.java)
        }
    }

    private fun showProgressBar() {
        lottieLoading.showAnimation()
    }

    private fun hideProgressBar() {
        lottieLoading.hideAnimation()
    }

    private fun showError(errorMessage: String) {
        splashContainer.snack(errorMessage)
    }
}