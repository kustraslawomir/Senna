package pl.senna.view.activity.splash

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.senna.usecases.NavigateToMainScreenAfterDelayUseCase
import pl.senna.utils.livedata.Event

class SplashViewModel : ViewModel(), LifecycleObserver {

    private val navigateToMainScreenEvent = MutableLiveData<Event<Boolean>>()

    fun getNavigateToMainScreenEvent(): LiveData<Event<Boolean>> = navigateToMainScreenEvent

    init {
        NavigateToMainScreenAfterDelayUseCase().apply {
            startSplashScreenDelay { navigateToMainScreen() }
        }
    }

    private fun navigateToMainScreen() {
        navigateToMainScreenEvent.value = Event(true)
    }
}