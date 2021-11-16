package com.tamimattafi.pizza.android.presentation.core.navigation

import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.DialogDestination
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.FragmentDestination

interface INavigator {
    fun openFragment(
        destination: FragmentDestination,
        addPreviousToBackStack: Boolean = true
    )

    fun openDialog(destination: DialogDestination)
}