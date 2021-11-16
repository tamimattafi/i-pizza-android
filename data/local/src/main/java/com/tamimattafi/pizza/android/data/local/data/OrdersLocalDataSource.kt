package com.tamimattafi.pizza.android.data.local.data

import androidx.room.rxjava3.EmptyResultSetException
import com.tamimattafi.pizza.android.data.local.IOrdersLocalDataSource
import com.tamimattafi.pizza.android.data.local.database.dao.IOrdersDao
import com.tamimattafi.pizza.android.data.local.entities.order.OrderEntity
import com.tamimattafi.pizza.android.data.local.entities.order.OrderWithPizzaEntity
import com.tamimattafi.pizza.domain.model.Order
import com.tamimattafi.pizza.domain.model.Order.Defaults.DEFAULT_QUANTITY_STEP
import com.tamimattafi.pizza.domain.model.Order.Defaults.MIN_QUANTITY
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

class OrdersLocalDataSource(
    private val dao: IOrdersDao
) : IOrdersLocalDataSource {

    override fun getAll(): Flowable<List<Order>> =
        dao.getAll().map { entitiesList ->
            entitiesList.map(OrderWithPizzaEntity::toOrder)
        }

    override fun add(pizzaId: Int): Completable =
        dao.getByPizzaId(pizzaId)
            .onErrorReturn { exception ->
                if (exception !is EmptyResultSetException) throw exception
                OrderEntity(pizzaId, MIN_QUANTITY)
            }.flatMapCompletable { order ->
                val newQuantity = order.quantity + DEFAULT_QUANTITY_STEP
                val newOrder = order.copy(quantity = newQuantity)
                dao.update(newOrder)
            }

    override fun remove(pizzaId: Int): Completable =
        dao.getByPizzaId(pizzaId)
            .flatMapCompletable { order ->
                val newQuantity = order.quantity - DEFAULT_QUANTITY_STEP
                if (newQuantity <= MIN_QUANTITY) {
                    dao.remove(order)
                } else {
                    val newOrder = order.copy(quantity = newQuantity)
                    dao.update(newOrder)
                }
            }

    override fun clear(): Completable =
        dao.removeAll()
}