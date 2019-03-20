package com.senna.utils.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.senna.com.R

class FragmentTransactions {

    companion object {
        fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, container: Int) {

            val fragmentToRemove = fragmentManager.findFragmentByTag(fragment::class.java.simpleName)
            if (fragmentToRemove != null)
                fragmentManager.beginTransaction().remove(fragmentToRemove).commit()

            fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                    .replace(container, fragment, fragment::class.java.simpleName)
                    .commit()
        }

        fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, container: Int) {

            val fragmentToRemove = fragmentManager.findFragmentByTag(fragment::class.java.simpleName)
            if (fragmentToRemove != null)
                fragmentManager.beginTransaction().remove(fragmentToRemove).commit()

            fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .setCustomAnimations(R.animator.fade_in, R.animator.fade_out)
                    .add(container, fragment, fragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
        }
    }
}