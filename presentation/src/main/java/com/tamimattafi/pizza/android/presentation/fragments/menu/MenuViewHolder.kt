package com.tamimattafi.pizza.android.presentation.fragments.menu

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.databinding.HolderPizzaBinding
import com.tamimattafi.pizza.domain.model.Pizza

class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewBinding by viewBinding(HolderPizzaBinding::bind)

    fun setName(name: String) {
        viewBinding.txtName.text = name
    }

    fun setDescription(description: String) {
        viewBinding.txtDescription.text = description
    }

    fun setImageUrl(imageUrl: String) {
        Glide.with(viewBinding.imgPizza)
            .load(imageUrl)
            .placeholder(R.drawable.ic_pizza_logo)
            .into(viewBinding.imgPizza)
    }

    fun setPrice(price: Double) {
        //TODO: format and use rouble sign
        viewBinding.txtPrice.text = price.toString()
    }
}