package pl.senna.view.fragment.compositions

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import pl.senna.Application
import pl.senna.model.firebase.Composition
import pl.senna.model.firebase.PublicCompositions
import pl.senna.usecases.GetPublicCompositionsUseCase
import timber.log.Timber
import javax.inject.Inject

class CompositionsViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var getDefaultCompositionsUseCase: GetPublicCompositionsUseCase

    private val compositions = MutableLiveData<List<Composition>>()

    fun getCompositions(): LiveData<List<Composition>> = compositions

    init {
        Application.component.inject(viewModel = this)
        getDefaultCompositionsUseCase.getPublicCompositions(::navigateToMainScreen)
    }

    private fun navigateToMainScreen(publicCompositions: PublicCompositions) {
        Timber.d("Public compositions: %s", Gson().toJson(publicCompositions))
        compositions.value = publicCompositions.compositions
    }
}