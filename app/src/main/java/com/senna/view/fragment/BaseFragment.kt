package com.senna.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.senna.view.activity.nagivation.NavigationActivity

abstract class BaseFragment : Fragment() {

    fun getNavigationActivity() = activity as NavigationActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View = inflater.inflate(getLayoutId(), container, false)

    protected abstract fun getLayoutId() : Int

    protected abstract fun getViewModel() : ViewModel

    fun <T : ViewModel> provideViewModel(@NonNull modelClass: Class<T>): T {
        return ViewModelProviders
                .of(this)
                .get(modelClass)
    }
}