package com.senna.view.activity.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.senna.Application
import timber.log.Timber

class MainViewModel : ViewModel(), LifecycleObserver {

    init {
        Application.component.inject(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Timber.e("Lifecycle -> ON_DESTROY")
    }
}