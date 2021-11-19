package com.tamimattafi.pizza.android.presentation.fragments.global.pizza

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.databinding.HolderPizzaBinding
import com.tamimattafi.pizza.android.presentation.utils.beautifyDouble
import com.tamimattafi.pizza.android.presentation.utils.setClickListener

class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
            .placeholder(R.drawable.background_primary)
            .into(viewBinding.imgPizza)
    }

    fun setPrice(price: Double) {
        val formattedPrice = price.beautifyDouble()
        viewBinding.txtPrice.text = itemView.context.getString(
            R.string.price_template,
            formattedPrice
        )
    }

    fun setClickListener(onClick: () -> Unit) {
        viewBinding.root.setClickListener(onClick)
    }
}