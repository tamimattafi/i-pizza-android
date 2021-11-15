package com.tamimattafi.pizza.android.data.remote.client.pizza

import com.tamimattafi.pizza.android.data.remote.bodies.pizza.PizzaBody
import com.tamimattafi.pizza.android.data.remote.client.global.Paths.PIZZA_ID_VARIABLE
import com.tamimattafi.pizza.android.data.remote.client.global.Paths.PIZZA_LIST_PATH
import com.tamimattafi.pizza.android.data.remote.client.global.Paths.PIZZA_PATH
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PizzaClient {

    @GET(PIZZA_LIST_PATH)
    fun getAll(): Single<List<PizzaBody>>

    @GET(PIZZA_PATH)
    fun getById(@Path(PIZZA_ID_VARIABLE) id: Int): Single<PizzaBody>
}