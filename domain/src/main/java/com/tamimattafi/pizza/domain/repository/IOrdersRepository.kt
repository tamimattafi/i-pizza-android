package com.tamimattafi.pizza.domain.repository

import com.tamimattafi.pizza.domain.model.order.Order
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface IOrdersRepository {
    fun getAll(): Flowable<List<Order>>
    fun add(pizzaId: Int): Completable
    fun remove(pizzaId: Int): Completable
    fun clear(): Completable
    fun submit(): Completable
}