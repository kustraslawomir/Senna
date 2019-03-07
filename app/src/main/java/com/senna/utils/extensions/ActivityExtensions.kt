package com.senna.utils.extensions

import android.app.Activity
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.senna.utils.navigation.FragmentTransactions

fun Activity.makeActivityFullScreen() {
    window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}

fun AppCompatActivity.replaceFragment(fragment : Fragment, id : Int) {
    FragmentTransactions.replaceFragment(supportFragmentManager,fragment, id)

}