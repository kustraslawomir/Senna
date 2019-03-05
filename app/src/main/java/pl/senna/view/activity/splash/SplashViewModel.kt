package pl.senna.view.activity.splash

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.senna.Application
import pl.senna.usecases.NavigateToMainScreenAfterDelayUseCase
import pl.senna.utils.livedata.Event
import javax.inject.Inject

class SplashViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var navigateToMainScreenAfterDelayUseCase: NavigateToMainScreenAfterDelayUseCase

    private val navigateToMainScreenEvent = MutableLiveData<Event<Boolean>>()

    fun getNavigateToMainScreenEvent(): LiveData<Event<Boolean>> = navigateToMainScreenEvent

    init {
        Application.component.inject(viewModel = this)
        navigateToMainScreenAfterDelayUseCase.startSplashScreenDelay { navigateToMainScreen() }
    }

    private fun navigateToMainScreen() {
        navigateToMainScreenEvent.value = Event(value = true)
    }
}