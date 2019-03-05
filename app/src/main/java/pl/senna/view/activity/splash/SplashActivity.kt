package pl.senna.view.activity.splash

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import pl.senna.com.R
import pl.senna.utils.extensions.isTrue
import pl.senna.utils.extensions.listen
import pl.senna.utils.extensions.replaceActivity
import pl.senna.view.activity.BaseActivity
import pl.senna.view.activity.main.NavigationActivity

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