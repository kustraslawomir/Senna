package com.senna.utils.extensions

import android.content.res.Resources
import android.widget.FrameLayout

fun FrameLayout.setPaddingFromNavBar(resources: Resources){
    if (hasNavBar(resources)) {
        this.setPadding(0, 0, 0, getNavViewHeight(resources))
    } else {
        this.setPadding(0, 0, 0, 50)
    }
}

fun hasNavBar(resources: Resources): Boolean {
    val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    return id > 0 && resources.getBoolean(id)
}

fun getNavViewHeight(resources: Resources): Int {
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        ((resources.getDimensionPixelSize(resourceId) + (resources.getDimensionPixelSize(resourceId))) * 0.6).toInt()
    } else 0
}