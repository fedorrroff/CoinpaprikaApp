package com.fedorrroff.coinpaprikaapp.ui.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.fedorrroff.coinpaprikaapp.R
import com.fedorrroff.coinpaprikaapp.ui.currencies.CurrenciesFragment

class NavigatorImpl(activity: AppCompatActivity) : Navigator{

    private val FRAGMENT_CONTAINER = R.id.fragment_container
    private val fragmentManager: FragmentManager = activity.supportFragmentManager

    override fun showMainScreen() {
        showFragmentBackStack(CurrenciesFragment().newInstance())
    }

    private fun showFragmentBackStack(fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(FRAGMENT_CONTAINER, fragment)
            .addToBackStack(null)
            .commit()
    }
}