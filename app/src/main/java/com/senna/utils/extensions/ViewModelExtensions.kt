package com.senna.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.listen(owner: LifecycleOwner, observer: (T) -> Unit) =
        observe(owner, Observer { observer(it) })