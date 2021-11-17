package com.tamimattafi.pizza.domain.usecase.order

import com.tamimattafi.pizza.domain.model.order.OrdersTotal
import io.reactivex.rxjava3.core.Flowable

class OrderGetWithTotal(private val orderGetAll: OrderGetAll) {

    operator fun invoke(): Flowable<OrdersTotal> = orderGetAll().map { orders ->
        val totalPrice = orders.sumOf { order ->
            order.quantity * order.pizza.price
        }

        OrdersTotal(orders, totalPrice)
    }
}