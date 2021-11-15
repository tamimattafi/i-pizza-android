package com.tamimattafi.pizza.android.data.remote.client.global

internal object Paths {
    const val PIZZA_LIST_PATH = "pizza"

    const val PIZZA_ID_VARIABLE = "id"
    const val PIZZA_PATH = "$PIZZA_LIST_PATH/{$PIZZA_ID_VARIABLE}"

    const val PIZZA_ORDER_PATH = "$PIZZA_LIST_PATH/order"
}