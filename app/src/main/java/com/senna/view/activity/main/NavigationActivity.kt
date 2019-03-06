package com.senna.view.activity.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.senna.com.R
import com.senna.utils.extensions.setLifeCycleObserver
import com.senna.utils.navigation.FragmentTransactions
import com.senna.view.activity.BaseActivity
import com.senna.view.fragment.compositions.CompositionsFragment

class NavigationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setLifeCycleObserver(viewModel)

        FragmentTransactions.replaceFragment(supportFragmentManager, CompositionsFragment(), R.id.content)
    }
}
