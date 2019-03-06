package com.senna.utils.extensions

import android.animation.ObjectAnimator
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.snackbar.Snackbar

inline fun <T : Any, R> whenNotNull(input: T?, callback: (T) -> R): R? {
    return input?.let(callback)
}

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun View.hide() {
    visibility = View.GONE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.shouldBeHideIf(condition : Boolean) {
    visibility = if (condition)
        View.GONE
    else View.VISIBLE
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.fade(value: Float) {
    val anim = ObjectAnimator.ofFloat(this, "alpha", value)
    anim.duration = 300
    anim.start()
}

fun DrawerLayout.close() {
    this.closeDrawer(GravityCompat.START)
}

fun DrawerLayout.open() = this.openDrawer(GravityCompat.START)

fun DrawerLayout.isOpen() = this.isDrawerOpen(GravityCompat.START)

fun DrawerLayout.enable() = this.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

fun DrawerLayout.disable() = this.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
