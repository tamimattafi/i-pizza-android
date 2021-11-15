package com.tamimattafi.pizza.android.data.repository

import com.tamimattafi.pizza.android.data.local.IPizzaLocalDataSource
import com.tamimattafi.pizza.android.data.remote.IPizzaRemoteDataSource
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable

class PizzaRepository(
    private val local: IPizzaLocalDataSource,
    private val remote: IPizzaRemoteDataSource
) : IPizzaRepository {

    override fun get(id: Int): Flowable<Pizza> =
        local.get(id).doOnSubscribe {
            this.syncPizza(id)
        }

    override fun getAll(): Flowable<List<Pizza>> =
        local.getAll().doOnSubscribe {
            this.syncPizzaList()
        }

    private fun syncPizzaList() =
        remote.getAll()
            .flatMapCompletable(local::insertAll)
            .subscribe()

    private fun syncPizza(id: Int) =
        remote.get(id)
            .flatMapCompletable(local::insert)
            .subscribe()
}