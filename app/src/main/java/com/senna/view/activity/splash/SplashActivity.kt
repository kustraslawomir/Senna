package com.senna.view.activity.splash

import android.os.Bundle
import com.senna.com.R
import com.senna.model.fetchstates.GetCompositionsNetworkState
import com.senna.utils.extensions.*
import com.senna.view.activity.base.BaseActivity
import com.senna.view.activity.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun getViewModel() = provideViewModel(SplashViewModel::class.java)

    override fun getContentView() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = getViewModel()
        observeNetworkState(viewModel)
        observeNavigationEvent(viewModel)
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
        viewModel.getShouldOpenNavigationScreen().listen(this) { navigateToMain ->
            if (navigateToMain.shouldBeHandled().isNotNullAndTrue())
                replaceActivity(NavigationActivity::class.java)
        }
    }

    private fun showProgressBar() = lottieLoading.show()

    private fun hideProgressBar() = lottieLoading.hide()

    private fun showError(errorMessage: String) = splashContainer.snack(errorMessage)
}