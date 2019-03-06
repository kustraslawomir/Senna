package com.senna.view.activity.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.senna.com.R
import com.senna.utils.extensions.isTrue
import com.senna.utils.extensions.listen
import com.senna.utils.extensions.replaceActivity
import com.senna.view.activity.BaseActivity
import com.senna.view.activity.main.NavigationActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        viewModel.getNavigateToMainScreenEvent().listen(this) { navigateToMain ->
            if (navigateToMain.shouldBeHandled().isTrue())
                replaceActivity(NavigationActivity::class.java)
        }
    }
}