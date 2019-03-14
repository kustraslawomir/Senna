package com.senna.view.activity.nagivation

import android.os.Bundle
import com.senna.com.R
import com.senna.utils.extensions.addFragment
import com.senna.utils.extensions.replaceFragment
import com.senna.view.activity.BaseActivity
import com.senna.view.fragment.compositions.CompositionsFragment
import com.senna.view.fragment.player.PlayerFragment

class NavigationActivity : BaseActivity() {

    override fun getContentView() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(CompositionsFragment(), R.id.content)
    }

    fun navigateTo(fragment: PlayerFragment) {
        addFragment(fragment, R.id.content)
    }
}
