package com.tamimattafi.pizza.android.data.remote

import com.tamimattafi.pizza.domain.model.Pizza
import io.reactivex.rxjava3.core.Single

interface IPizzaRemoteDataSource {
    fun getAll(): Single<List<Pizza>>
    fun get(id: Int): Single<Pizza>
}