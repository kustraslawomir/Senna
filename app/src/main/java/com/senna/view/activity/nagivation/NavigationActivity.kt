package com.senna.view.activity.nagivation

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.senna.com.R
import com.senna.utils.extensions.replaceFragment
import com.senna.view.activity.BaseActivity
import com.senna.view.fragment.compositions.CompositionsFragment

class NavigationActivity : BaseActivity() {

    override fun getViewModel() = provideViewModel(NavigationViewModel::class.java)

    override fun getContentView() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(withBackStack = false, fragment = CompositionsFragment())
    }

    fun replaceFragment(withBackStack: Boolean, fragment: Fragment) =
            replaceFragment(withBackStack = withBackStack,
                    fragment = fragment,
                    view = R.id.content)
}
