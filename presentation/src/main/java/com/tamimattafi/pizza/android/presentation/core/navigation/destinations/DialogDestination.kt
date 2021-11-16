package com.tamimattafi.pizza.android.presentation.core.navigation.destinations

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class DialogDestination : Parcelable {

    @Parcelize
    class PizzaDetails(
        val pizzaId: Int
    ) : DialogDestination()
}



