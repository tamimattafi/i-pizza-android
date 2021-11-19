package com.tamimattafi.pizza.android.data.remote.data

import com.tamimattafi.pizza.android.data.remote.IOrdersRemoteDataSource
import com.tamimattafi.pizza.android.data.remote.bodies.order.OrderBody
import com.tamimattafi.pizza.android.data.remote.client.order.IOrderClient
import com.tamimattafi.pizza.domain.model.order.Order
import io.reactivex.rxjava3.core.Completable

class OrdersRemoteDataSource(
    private val client: IOrderClient
) : IOrdersRemoteDataSource {

    override fun submit(orders: List<Order>): Completable =
        orders.map(OrderBody.Companion::fromOrder)
            .let(client::placeOrder)
}