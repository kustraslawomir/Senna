package com.senna.view.fragment

import androidx.fragment.app.Fragment
import com.senna.view.activity.nagivation.NavigationActivity

open class BaseFragment : Fragment() {

    fun getNaviagtionActivity() = activity as NavigationActivity
}