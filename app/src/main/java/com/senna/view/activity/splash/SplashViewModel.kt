package com.senna.view.activity.splash

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senna.SennaApplication
import com.senna.model.fetchstates.GetCompositionsNetworkState
import com.senna.usecases.compositions.FetchPublicCompositionsUseCase
import com.senna.usecases.compositions.GetStoredCompositionsUseCase
import com.senna.usecases.compositions.StorePublicCompositionsUseCase
import com.senna.usecases.delays.SplashDelayUseCase
import com.senna.utils.livedata.Event
import javax.inject.Inject

class SplashViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var fetchDefaultCompositionsUseCase: FetchPublicCompositionsUseCase
    @Inject
    lateinit var storePublicCompositionsUseCase: StorePublicCompositionsUseCase
    @Inject
    lateinit var navigateToMainScreenAfterDelayUseCase: SplashDelayUseCase
    @Inject
    lateinit var getStoredCompositionsUseCase: GetStoredCompositionsUseCase

    private val navigateToMainScreenEvent = MutableLiveData<Event<Boolean>>()

    private val fetchingStatus = MutableLiveData<GetCompositionsNetworkState>()

    init {
        SennaApplication.component.inject(viewModel = this)

        fetchPublicCompositions()
       /* if (compositionsAreEmpty())
            fetchPublicCompositions()
        else startSplashDelay()*/
    }

    private fun fetchPublicCompositions() = fetchDefaultCompositionsUseCase.fetchPublicCompositions(::onFetchingStatusChange)

    private fun onFetchingStatusChange(result: GetCompositionsNetworkState) {
        when (result) {
            is GetCompositionsNetworkState.Response -> storePublicCompositionsUseCase.storeCompositions(result.publicCompositions, ::startSplashDelay)
            is GetCompositionsNetworkState.Error, GetCompositionsNetworkState.Loading -> fetchingStatus.value = result
        }
    }

    private fun startSplashDelay() = navigateToMainScreenAfterDelayUseCase.startSplashScreenDelay(::onSplashScreenDelayEnded)

    private fun onSplashScreenDelayEnded() {
        navigateToMainScreenEvent.value = Event(value = true)
    }

    fun getNavigateToMainScreenEvent(): LiveData<Event<Boolean>> = navigateToMainScreenEvent

    fun getFetchingStatus(): LiveData<GetCompositionsNetworkState> = fetchingStatus

    private fun compositionsAreEmpty() = getStoredCompositionsUseCase.getCompositionsSize() == 0
}
