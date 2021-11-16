package com.tamimattafi.pizza.android.presentation.fragments.menu

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.utils.inflate
import com.tamimattafi.pizza.domain.model.Pizza
import javax.inject.Inject

class MenuRecyclerAdapter @Inject constructor() : SimpleRecyclerAdapter<Pizza, MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = parent.inflate(R.layout.holder_pizza)
        return MenuViewHolder(view)
    }

    override fun bindHolder(holder: MenuViewHolder, item: Pizza) {
        holder.apply {
            setName(item.name)
            setDescription(item.description)
            val firstImage = item.imageUrls.first()
            setImageUrl(firstImage)
            setPrice(item.price)
        }
    }

    override fun createDiffCallback(oldData: List<Pizza>, newData: List<Pizza>): DiffUtil.Callback
        = MenuDiffCallBack(oldData, newData)
}