package com.senna.utils.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.senna.com.R

fun Context.replaceActivity(screen: Class<*>) {
    val intent = Intent(this, screen)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
}

fun Activity.fadeTransition() {
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
}

@SuppressLint("HardwareIds")
fun Context.getUuid(): String {
    return Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
}

fun AppCompatActivity.hideKeyboard(view: View?) {
    if (view != null) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Fragment.setLifeCycleObserver(viewModel: LifecycleObserver) {
    this.lifecycle.addObserver(viewModel)
}

fun AppCompatActivity.setLifeCycleObserver(viewModel: LifecycleObserver) {
    this.lifecycle.addObserver(viewModel)
}