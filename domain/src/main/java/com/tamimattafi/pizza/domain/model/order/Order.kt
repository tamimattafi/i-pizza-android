package com.tamimattafi.pizza.domain.model.order

import com.tamimattafi.pizza.domain.model.Pizza

data class Order(
    val pizza: Pizza,
    val quantity: Int
) {
    object Defaults {
        const val DEFAULT_QUANTITY_STEP = 1
        const val MIN_QUANTITY = 0
    }
}