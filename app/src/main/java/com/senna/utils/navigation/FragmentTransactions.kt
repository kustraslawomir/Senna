package com.senna.utils.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class FragmentTransactions {

    companion object {
        fun replaceFragment(fragmentManager: FragmentManager, fragment: Fragment, container: Int) {

            val fragmentToRemove = fragmentManager.findFragmentByTag(fragment::class.java.simpleName)
            if (fragmentToRemove != null)
                fragmentManager.beginTransaction().remove(fragmentToRemove).commit()

            fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(container, fragment, fragment::class.java.simpleName)
                    .commit()
        }

        fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, container: Int) {

            val fragmentToRemove = fragmentManager.findFragmentByTag(fragment::class.java.simpleName)
            if (fragmentToRemove != null)
                fragmentManager.beginTransaction().remove(fragmentToRemove).commit()

            fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .add(container, fragment, fragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
        }
    }
}