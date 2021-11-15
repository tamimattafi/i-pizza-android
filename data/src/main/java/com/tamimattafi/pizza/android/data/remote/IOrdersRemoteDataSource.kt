package com.tamimattafi.pizza.android.data.remote

import com.tamimattafi.pizza.domain.model.Order
import io.reactivex.rxjava3.core.Completable

interface IOrdersRemoteDataSource {
    fun submit(orders: List<Order>): Completable
}