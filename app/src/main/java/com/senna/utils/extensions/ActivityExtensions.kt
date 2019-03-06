package com.senna.utils.extensions

import android.app.Activity
import android.view.WindowManager

fun Activity.makeActivityFullScreen() {
    window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}