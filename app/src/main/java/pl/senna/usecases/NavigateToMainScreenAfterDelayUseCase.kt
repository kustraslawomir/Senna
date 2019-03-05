package pl.senna.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.android.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.senna.utils.Constants

class NavigateToMainScreenAfterDelayUseCase {

    fun startSplashScreenDelay(navigateToMainScreen: () -> Unit){
        GlobalScope.launch(context = Dispatchers.Main) {
            delay(Constants.SPLASH_SCREEN_DELAY)
            navigateToMainScreen()
        }
    }
}