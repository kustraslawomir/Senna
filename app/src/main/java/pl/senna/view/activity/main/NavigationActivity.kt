package pl.senna.view.activity.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import pl.senna.com.R
import pl.senna.utils.extensions.setLifeCycleObserver
import pl.senna.utils.navigation.FragmentTransactions
import pl.senna.view.activity.BaseActivity
import pl.senna.view.fragment.map.CompositionsFragment

class NavigationActivity : BaseActivity() {

    internal lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setLifeCycleObserver(viewModel)

        replaceCurrentScreen(CompositionsFragment())
    }

    internal fun replaceCurrentScreen(fragment: Fragment) = FragmentTransactions.replaceFragment(supportFragmentManager, fragment, R.id.content)
}
