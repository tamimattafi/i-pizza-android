package com.tamimattafi.pizza.android.data.repository

import com.tamimattafi.pizza.android.data.local.IOrdersLocalDataSource
import com.tamimattafi.pizza.android.data.remote.IOrdersRemoteDataSource
import com.tamimattafi.pizza.domain.model.order.Order
import com.tamimattafi.pizza.domain.repository.IOrdersRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class OrdersRepository(
    private val local: IOrdersLocalDataSource,
    private val remote: IOrdersRemoteDataSource
) : IOrdersRepository {

    override fun getAll(): Flowable<List<Order>> =
        local.getAll()
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())

    override fun add(pizzaId: Int): Completable =
        local.add(pizzaId)
            .subscribeOn(Schedulers.io())

    override fun remove(pizzaId: Int): Completable =
        local.remove(pizzaId)
            .subscribeOn(Schedulers.io())

    override fun clear(): Completable =
        local.clear()
            .subscribeOn(Schedulers.io())

    override fun submit(): Completable =
        local.getAll()
            .subscribeOn(Schedulers.io())
            .firstOrError()
            .flatMapCompletable(remote::submit)
            .andThen(clear())
}