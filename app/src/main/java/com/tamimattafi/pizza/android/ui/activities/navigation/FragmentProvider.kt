package com.tamimattafi.pizza.android.ui.activities.navigation

import androidx.fragment.app.Fragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination.Fragment.*
import com.tamimattafi.pizza.android.presentation.fragments.pizza.menu.MenuFragment

object FragmentProvider {

    fun provide(destination: Destination.Fragment): Fragment
        = when (destination) {
            Menu -> MenuFragment()
            is PizzaGallery -> TODO()
        }.apply {
            storeDestination(destination)
        }
}