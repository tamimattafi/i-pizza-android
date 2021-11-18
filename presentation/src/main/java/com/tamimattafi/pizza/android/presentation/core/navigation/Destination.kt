package com.tamimattafi.pizza.android.presentation.core.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface Destination {

    sealed interface Direction : Destination {

        object Back : Direction
    }

    sealed interface Dialog : Destination, Parcelable {

        @Parcelize
        class PizzaDetails(
            val pizzaId: Int
        ) : Dialog
    }

    sealed interface Fragment : Destination, Parcelable {

        @Parcelize
        object Menu : Fragment

        @Parcelize
        class Gallery(
            val pizzaId: Int
        ) : Fragment

        @Parcelize
        object Search : Fragment

        @Parcelize
        object Cart : Fragment

        @Parcelize
        object OrderSuccess : Fragment
    }
}




