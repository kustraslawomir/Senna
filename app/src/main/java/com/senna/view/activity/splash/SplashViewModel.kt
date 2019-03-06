package com.senna.view.activity.splash

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senna.Application
import com.senna.model.firebase.PublicCompositions
import com.senna.usecases.FetchPublicCompositionsUseCase
import com.senna.usecases.NavigateToMainScreenAfterDelayUseCase
import com.senna.usecases.StorePublicCompositionsUseCase
import com.senna.utils.livedata.Event
import javax.inject.Inject

class SplashViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var fetchDefaultCompositionsUseCase: FetchPublicCompositionsUseCase
    @Inject
    lateinit var storePublicCompositionsUseCase: StorePublicCompositionsUseCase
    @Inject
    lateinit var navigateToMainScreenAfterDelayUseCase: NavigateToMainScreenAfterDelayUseCase

    private val navigateToMainScreenEvent = MutableLiveData<Event<Boolean>>()

    init {
        Application.component.inject(viewModel = this)
        fetchPublicCompositions()
    }

    private fun fetchPublicCompositions() {
        fetchDefaultCompositionsUseCase.fetchPublicCompositions(::onFetchPublicCompositionsEnd)
    }

    private fun onFetchPublicCompositionsEnd(publicCompositions: PublicCompositions) {
        storePublicCompositionsUseCase.storeCompositions(publicCompositions, ::onCompositionsStored)
    }

    private fun onCompositionsStored() {
        navigateToMainScreenAfterDelayUseCase.startSplashScreenDelay(::onSplashScreenDelayEnded)
    }

    private fun onSplashScreenDelayEnded() {
        navigateToMainScreenEvent.value = Event(value = true)
    }

    fun getNavigateToMainScreenEvent(): LiveData<Event<Boolean>> = navigateToMainScreenEvent
}
