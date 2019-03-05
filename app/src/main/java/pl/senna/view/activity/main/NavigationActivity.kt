package pl.senna.view.activity.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import pl.senna.com.R
import pl.senna.utils.extensions.setLifeCycleObserver
import pl.senna.utils.navigation.FragmentTransactions
import pl.senna.view.activity.BaseActivity
import pl.senna.view.fragment.compositions.CompositionsFragment

class NavigationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setLifeCycleObserver(viewModel)

        FragmentTransactions.replaceFragment(supportFragmentManager, CompositionsFragment(), R.id.content)
    }
}
