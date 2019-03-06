package com.senna.view.fragment.compositions

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senna.Application
import com.senna.model.databse.Composition
import com.senna.usecases.compositions.GetStoredCompositionsUseCase
import javax.inject.Inject

class CompositionsViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var getStoredCompositionsUseCase: GetStoredCompositionsUseCase

    private val compositionsLiveData = MutableLiveData<List<Composition>>()

    init {
        Application.component.inject(viewModel = this)
        getStoredCompositionsUseCase.getCompositions(::setComposition)
    }

    private fun setComposition(compositions : List<Composition>) {
        compositionsLiveData.value = compositions
    }

    fun getCompositionsLiveData(): LiveData<List<Composition>> = compositionsLiveData
}