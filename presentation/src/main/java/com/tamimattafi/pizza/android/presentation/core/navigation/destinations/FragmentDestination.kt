package com.tamimattafi.pizza.android.presentation.core.navigation.destinations

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class FragmentDestination : Parcelable {

    @Parcelize
    object Menu : FragmentDestination()

    @Parcelize
    class PizzaGallery(
        val pizzaId: Int
    ) : FragmentDestination()
}

