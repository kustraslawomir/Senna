package com.senna.utils.customview.playerview.utils

import android.graphics.Bitmap

class Star(
    var star: Bitmap?,
    val x: Float,
    val y: Float,
    var shouldAnimate: Boolean
) {
    internal var alpha = 255
}