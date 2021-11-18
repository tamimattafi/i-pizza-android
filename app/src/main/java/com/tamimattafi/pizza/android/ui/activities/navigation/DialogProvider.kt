package com.tamimattafi.pizza.android.ui.activities.navigation

import androidx.fragment.app.DialogFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination.Dialog.*
import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.DetailsDialog

object DialogProvider {

    fun provide(destination: Destination.Dialog): DialogFragment =
        when (destination) {
            is PizzaDetails -> DetailsDialog()
        }.apply {
            storeDestination(destination)
        }
}