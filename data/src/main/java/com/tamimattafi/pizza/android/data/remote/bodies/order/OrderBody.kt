package com.tamimattafi.pizza.android.data.remote.bodies.order

import com.fasterxml.jackson.annotation.JsonProperty

data class OrderBody(
    @JsonProperty(value = "pizzaId", required = true)
    val pizzaId: Int,
    @JsonProperty(value = "quantity", required = true)
    val quantity: Int
)