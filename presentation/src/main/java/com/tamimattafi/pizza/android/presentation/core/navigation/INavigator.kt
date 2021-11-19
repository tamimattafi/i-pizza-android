package com.tamimattafi.pizza.android.presentation.core.navigation

interface INavigator {
    fun toDirection(destination: Destination.Direction)

    fun openFragment(
        destination: Destination.Fragment,
        addPreviousToBackStack: Boolean = true
    )

    fun openDialog(destination: Destination.Dialog)
}