package com.tamimattafi.pizza.domain.repository

import com.tamimattafi.pizza.domain.model.Pizza
import io.reactivex.rxjava3.core.Flowable

interface IPizzaRepository {
    fun get(id: Int): Flowable<Pizza>
    fun getAll(): Flowable<List<Pizza>>
}