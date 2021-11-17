package com.tamimattafi.pizza.domain.usecase.order

import io.reactivex.rxjava3.core.Flowable

class OrderGetTotal(private val orderGetAll: OrderGetAll) {

    operator fun invoke(): Flowable<Double> = orderGetAll().map { orders ->
        orders.sumOf { order ->
            order.quantity * order.pizza.price
        }
    }
}