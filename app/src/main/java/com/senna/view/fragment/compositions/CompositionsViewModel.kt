package com.senna.view.fragment.compositions

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senna.Application
import com.senna.model.databse.Composition
import com.senna.usecases.GetStoredPublicCompositionsUseCase
import javax.inject.Inject

class CompositionsViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var getStoredPublicCompositionsUseCase: GetStoredPublicCompositionsUseCase

    private val compositionsLiveData = MutableLiveData<List<Composition>>()

    init {
        Application.component.inject(viewModel = this)
        getStoredPublicCompositionsUseCase.getCompositions(::setComposition)
    }

    fun getCompositionsLiveData(): LiveData<List<Composition>> = compositionsLiveData

    private fun setComposition(compositions : List<Composition>) {
        compositionsLiveData.value = compositions
    }
}