package com.tamimattafi.pizza.android.data.remote.client.order

import com.tamimattafi.pizza.android.data.remote.bodies.order.OrderBody
import com.tamimattafi.pizza.android.data.remote.client.global.Paths.PIZZA_ORDER_PATH
import io.reactivex.rxjava3.core.Completable
import retrofit2.http.Body
import retrofit2.http.POST

interface OrderClient {

    @POST(PIZZA_ORDER_PATH)
    fun placeOrder(@Body list: List<OrderBody>): Completable
}