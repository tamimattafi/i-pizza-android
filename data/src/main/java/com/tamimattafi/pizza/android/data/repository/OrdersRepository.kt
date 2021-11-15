package com.tamimattafi.pizza.android.data.repository

import com.tamimattafi.pizza.android.data.local.IOrdersLocalDataSource
import com.tamimattafi.pizza.android.data.remote.IOrdersRemoteDataSource
import com.tamimattafi.pizza.domain.model.Order
import com.tamimattafi.pizza.domain.repository.IOrdersRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class OrdersRepository(
    private val local: IOrdersLocalDataSource,
    private val remote: IOrdersRemoteDataSource
) : IOrdersRepository {

    override fun getAll(): Flowable<List<Order>> =
        local.getAll()

    override fun add(pizzaId: Int): Completable =
        local.add(pizzaId)

    override fun remove(pizzaId: Int): Completable =
        local.remove(pizzaId)

    override fun clear(): Completable =
        local.clear()

    override fun submit(): Completable =
        local.getAll()
            .firstOrError()
            .flatMapCompletable(remote::submit)
            .andThen(clear())
}