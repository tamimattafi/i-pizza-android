package com.tamimattafi.pizza.android.presentation.core.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface Destination : Parcelable {

    sealed interface Dialog : Destination {

        @Parcelize
        class PizzaDetails(
            val pizzaId: Int
        ) : Dialog
    }

    sealed interface Fragment : Destination {

        @Parcelize
        object Menu : Fragment

        @Parcelize
        class PizzaGallery(
            val pizzaId: Int
        ) : Fragment
    }
}




