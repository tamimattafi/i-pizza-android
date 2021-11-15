package com.tamimattafi.pizza.android.data.remote.data

import com.tamimattafi.pizza.android.data.remote.IPizzaRemoteDataSource
import com.tamimattafi.pizza.android.data.remote.bodies.pizza.PizzaBody
import com.tamimattafi.pizza.android.data.remote.client.pizza.IPizzaClient
import com.tamimattafi.pizza.domain.model.Pizza
import io.reactivex.rxjava3.core.Single

class PizzaRemoteDataSource(
    private val client: IPizzaClient
) : IPizzaRemoteDataSource {

    override fun getAll(): Single<List<Pizza>> =
        client.getAll().map { pizzaList ->
            pizzaList.map(PizzaBody::toPizza)
        }

    override fun get(id: Int): Single<Pizza> =
        client.getById(id).map(PizzaBody::toPizza)
}