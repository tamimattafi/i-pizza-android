package com.tamimattafi.pizza.android.presentation.fragments.orders.cart

import android.view.ViewGroup
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.utils.inflate
import com.tamimattafi.pizza.domain.model.order.Order
import com.tamimattafi.pizza.domain.model.Pizza
import javax.inject.Inject

class CartRecyclerAdapter @Inject constructor(
    private val eventListener: IEventListener
) : SimpleRecyclerAdapter<Order, CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = parent.inflate(R.layout.holder_order)
        return CartViewHolder(view)
    }

    override fun bindHolder(holder: CartViewHolder, item: Order) {
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

    private fun bindPizza(holder: CartViewHolder, pizza: Pizza) =
        holder.apply {
            setName(pizza.name)
            val firstImage = pizza.imageUrls.first()
            setImageUrl(firstImage)
            setPrice(pizza.price)
        }

    override fun createDiffCallback(oldData: List<Order>, newData: List<Order>)
        = CartDiffCallBack(oldData, newData)

    interface IEventListener {
        fun onItemClick(order: Order)
        fun onAddClick(order: Order)
        fun onRemoveClick(order: Order)
    }
}