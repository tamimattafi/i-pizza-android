package com.tamimattafi.pizza.domain.model.order

data class OrdersTotal(
    val orders: List<Order>,
    val totalPrice: Double
)