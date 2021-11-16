package com.tamimattafi.pizza.android.presentation.fragments.pizza.menu

import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleDiffUtilCallback
import com.tamimattafi.pizza.domain.model.Pizza

class MenuDiffCallBack(
    oldData: List<Pizza>,
    newData: List<Pizza>
) : SimpleDiffUtilCallback<Pizza>(
    oldData,
    newData
) {

    override fun areItemIdentitiesTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
        oldItem.id == newItem.id

    override fun areDisplayContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean =
        oldItem.name == newItem.name &&
                oldItem.description == newItem.description &&
                oldItem.price == newItem.price &&
                oldItem.imageUrls.first() == newItem.imageUrls.first()
}