package com.tamimattafi.pizza.android.data.local

import com.tamimattafi.pizza.domain.model.order.Order
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

interface IOrdersLocalDataSource {
    fun getAll(): Flowable<List<Order>>
    fun add(pizzaId: Int): Completable
    fun remove(pizzaId: Int): Completable
    fun clear(): Completable
}