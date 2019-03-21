package com.senna.view.activity.nagivation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.senna.com.R
import com.senna.utils.extensions.addFragment
import com.senna.utils.extensions.replaceFragment
import com.senna.utils.extensions.replaceFragmentWithoutBackStack
import com.senna.view.activity.BaseActivity
import com.senna.view.fragment.compositions.CompositionsFragment

class NavigationActivity : BaseActivity() {

    override fun getViewModel() = ViewModelProviders.of(this).get(NavigationViewModel::class.java)

    override fun getContentView() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragmentWithoutBackStack(CompositionsFragment(), R.id.content)
    }

    fun addFragment(fragment: Fragment) {
        addFragment(fragment, R.id.content)
    }

    fun replaceFragment(fragment: Fragment) {
        replaceFragment(fragment, R.id.content)
    }
}
