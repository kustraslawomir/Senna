package com.senna.view.activity.nagivation

import android.os.Bundle
import com.senna.com.R
import com.senna.utils.extensions.addFragment
import com.senna.utils.extensions.replaceFragment
import com.senna.view.activity.BaseActivity
import com.senna.view.fragment.compositions.CompositionsFragment
import com.senna.view.fragment.player.PlayerFragment

class NavigationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(CompositionsFragment(), R.id.content)
    }

    fun navigateTo(fragment: PlayerFragment) {
        addFragment(fragment, R.id.content)
    }
}
