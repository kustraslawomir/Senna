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
import com.senna.utils.livedata.Event
import javax.inject.Inject

class SplashViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var fetchDefaultCompositionsUseCase: FetchPublicCompositionsUseCase
    @Inject
    lateinit var storePublicCompositionsUseCase: StorePublicCompositionsUseCase
    @Inject
    lateinit var getStoredCompositionsUseCase: GetStoredCompositionsUseCase

    private val shouldOpenNavigationScreen = MutableLiveData<Event<Boolean>>()

    init {
        SennaApplication.component.inject(viewModel = this)

        when (compositionsAreNullOrEmpty()) {
            true -> fetchPublicCompositions()
            false -> openNavigationScreen()
        }
    }


    private val fetchingStatus = MutableLiveData<GetCompositionsNetworkState>()

    private fun fetchPublicCompositions() = fetchDefaultCompositionsUseCase.fetchPublicCompositions(::onFetchingStatusChange)

    private fun onFetchingStatusChange(result: GetCompositionsNetworkState) {
        when (result) {
            is GetCompositionsNetworkState.Success -> storePublicCompositionsUseCase.storeCompositions(result.publicCompositions, ::storeCompositionsCompleted)
            is GetCompositionsNetworkState.Error, GetCompositionsNetworkState.Loading -> fetchingStatus.value = result
        }
    }

    private fun storeCompositionsCompleted() = openNavigationScreen()

    private fun openNavigationScreen() {
        shouldOpenNavigationScreen.value = Event(value = true)
    }

    fun getShouldOpenNavigationScreen(): LiveData<Event<Boolean>> = shouldOpenNavigationScreen

    fun getFetchingStatus(): LiveData<GetCompositionsNetworkState> = fetchingStatus

    private fun compositionsAreNullOrEmpty() = getStoredCompositionsUseCase.compositionsAreNullOrEmpty()
}
