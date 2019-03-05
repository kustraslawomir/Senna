package pl.senna.usecases

import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import pl.senna.utils.Constants

class NavigateToMainScreenAfterDelayUseCase {

    fun startSplashScreenDelay(navigateToMainScreen: () -> Unit){
        GlobalScope.launch(Dispatchers.Main) {
            delay(Constants.SPLASH_SCREEN_DELAY)
            navigateToMainScreen()
        }
    }
}