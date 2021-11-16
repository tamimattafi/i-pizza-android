package com.tamimattafi.pizza.android.presentation.core.navigation

interface INavigator {
    fun openFragment(
        destination: Destination.Fragment,
        addPreviousToBackStack: Boolean = true
    )

    fun openDialog(destination: Destination.Dialog)
}