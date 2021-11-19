package com.tamimattafi.pizza.android.data.local.data

import com.tamimattafi.pizza.android.data.local.IPizzaLocalDataSource
import com.tamimattafi.pizza.android.data.local.database.dao.IPizzaDao
import com.tamimattafi.pizza.android.data.local.entities.PizzaEntity
import com.tamimattafi.pizza.domain.model.Pizza
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class PizzaLocalDataSource(
    private val dao: IPizzaDao
) : IPizzaLocalDataSource {

    override fun insert(pizza: Pizza): Completable =
        PizzaEntity.toEntity(pizza)
            .let(dao::insert)

    override fun insertAll(pizzaList: List<Pizza>): Completable =
        pizzaList.map(PizzaEntity.Companion::toEntity)
            .let(dao::insertAll)

    override fun get(id: Int): Flowable<Pizza> =
        dao.getById(id)
            .map(PizzaEntity::toPizza)

    override fun getAll(): Flowable<List<Pizza>> =
        dao.getAll()
            .map(PizzaEntity::toPizzaList)

    override fun search(query: String): Flowable<List<Pizza>> =
        dao.search(query)
            .map(PizzaEntity::toPizzaList)
}