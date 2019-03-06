package com.senna.utils.extensions

import timber.log.Timber

fun Throwable.print() {
    Timber.e("ERROR: ${this.message}")
}