package com.senna.usecases.delays

import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import com.senna.utils.Constants

class SplashDelayUseCase {

    fun startSplashScreenDelay(onSplashScreenDelayEnded: () -> Unit){
        GlobalScope.launch(Dispatchers.Main) {
            delay(Constants.SPLASH_SCREEN_DELAY)
            onSplashScreenDelayEnded()
        }
    }
}