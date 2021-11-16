package com.tamimattafi.pizza.android.ui.activities

import android.os.Bundle
import com.tamimattafi.pizza.android.R
import com.tamimattafi.pizza.android.presentation.core.navigation.*
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.DialogDestination
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.FragmentDestination
import com.tamimattafi.pizza.android.ui.navigation.DialogProvider
import com.tamimattafi.pizza.android.ui.navigation.FragmentProvider
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity(), INavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_Light)
        setContentView(R.layout.activity_main)

        this.openFragment(
            FragmentDestination.Menu,
            addPreviousToBackStack = false
        )
    }

    override fun openFragment(
        destination: FragmentDestination,
        addPreviousToBackStack: Boolean
    ) {
        val fragment = FragmentProvider.provide(destination)
        val transaction = supportFragmentManager.beginTransaction().replace(
            R.id.fragmentContainer,
            fragment
        )

        if (addPreviousToBackStack) {
            transaction.addToBackStack(fragment.javaClass.name)
        }

        transaction.commit()
    }

    override fun openDialog(destination: DialogDestination) {
        val dialog = DialogProvider.provide(destination)
        dialog.showNow(supportFragmentManager, dialog.javaClass.name)
    }
}