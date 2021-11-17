package com.tamimattafi.pizza.android.presentation.fragments.orders

import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleDiffUtilCallback
import com.tamimattafi.pizza.domain.model.order.Order
import com.tamimattafi.pizza.domain.model.Pizza

class OrdersDiffCallBack(
    oldData: List<Order>,
    newData: List<Order>
) : SimpleDiffUtilCallback<Order>(
    oldData,
    newData
) {

    override fun areItemIdentitiesTheSame(oldItem: Order, newItem: Order): Boolean =
        oldItem.pizza.id == newItem.pizza.id

    override fun areDisplayContentsTheSame(oldItem: Order, newItem: Order): Boolean =
        arePizzaTheSame(oldItem.pizza, newItem.pizza) &&
                oldItem.quantity == newItem.quantity

    private fun arePizzaTheSame(oldPizza: Pizza, newPizza: Pizza) =
        oldPizza.name == newPizza.name &&
                oldPizza.description == newPizza.description &&
                oldPizza.price == newPizza.price &&
                oldPizza.imageUrls.first() == newPizza.imageUrls.first()
}