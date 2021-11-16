package com.tamimattafi.pizza.android.ui.navigation

import androidx.fragment.app.DialogFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.DialogDestination
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.DialogDestination.*

object DialogProvider {

    fun provide(destination: DialogDestination): DialogFragment =
        when (destination) {
            is PizzaDetails -> TODO()
        }
}