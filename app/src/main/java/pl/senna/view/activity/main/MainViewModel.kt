package pl.senna.view.activity.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import pl.senna.Application
import pl.senna.repository.local.AppDataBase
import timber.log.Timber
import javax.inject.Inject

class MainViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var database: AppDataBase

    init {
        Application.appComponent.inject(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Timber.e("Lifecycle -> ON_DESTROY")
    }
}