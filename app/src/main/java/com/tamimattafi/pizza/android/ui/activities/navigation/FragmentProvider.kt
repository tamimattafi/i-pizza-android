package com.tamimattafi.pizza.android.ui.activities.navigation

import androidx.fragment.app.Fragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination.Fragment.*
import com.tamimattafi.pizza.android.presentation.fragments.orders.OrdersFragment
import com.tamimattafi.pizza.android.presentation.fragments.pizza.menu.MenuFragment
import com.tamimattafi.pizza.android.presentation.fragments.pizza.search.SearchFragment

object FragmentProvider {

    fun provide(destination: Destination.Fragment): Fragment
        = when (destination) {
            Menu -> MenuFragment()
            Search -> SearchFragment()
            Orders -> OrdersFragment()
            is PizzaGallery -> TODO()
        }.apply {
            storeDestination(destination)
        }
}