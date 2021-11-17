package com.tamimattafi.pizza.android.presentation.fragments.orders

import android.view.ViewGroup
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.utils.inflate
import com.tamimattafi.pizza.domain.model.order.Order
import com.tamimattafi.pizza.domain.model.Pizza
import javax.inject.Inject

class OrdersRecyclerAdapter @Inject constructor(
    private val eventListener: IEventListener
) : SimpleRecyclerAdapter<Order, OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = parent.inflate(R.layout.holder_order)
        return OrderViewHolder(view)
    }

    override fun bindHolder(holder: OrderViewHolder, item: Order) {
        bindPizza(holder, item.pizza)

        holder.apply {
            setQuantity(item.quantity)

            setClickListener {
                eventListener.onItemClick(item)
            }

            setAddClickListener {
                eventListener.onAddClick(item)
            }

            setRemoveClickListener {
                eventListener.onRemoveClick(item)
            }
        }
    }

    private fun bindPizza(holder: OrderViewHolder, pizza: Pizza) =
        holder.apply {
            setName(pizza.name)
            val firstImage = pizza.imageUrls.first()
            setImageUrl(firstImage)
            setPrice(pizza.price)
        }

    override fun createDiffCallback(oldData: List<Order>, newData: List<Order>)
        = OrdersDiffCallBack(oldData, newData)

    interface IEventListener {
        fun onItemClick(order: Order)
        fun onAddClick(order: Order)
        fun onRemoveClick(order: Order)
    }
}