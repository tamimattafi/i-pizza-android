package com.tamimattafi.pizza.android.ui.navigation

import androidx.fragment.app.Fragment
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.FragmentDestination
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.FragmentDestination.*
import com.tamimattafi.pizza.android.presentation.fragments.menu.MenuFragment

object FragmentProvider {

    fun provide(destination: FragmentDestination): Fragment
        = when (destination) {
            Menu -> MenuFragment()
            is PizzaGallery -> TODO()
        }.apply {
            storeDestination(destination)
        }
}