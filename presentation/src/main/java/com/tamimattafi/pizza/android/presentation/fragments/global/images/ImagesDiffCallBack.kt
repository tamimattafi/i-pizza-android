package com.tamimattafi.pizza.android.presentation.fragments.global.images

import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleDiffUtilCallback

class ImagesDiffCallBack(
    oldData: List<String>,
    newData: List<String>
) : SimpleDiffUtilCallback<String>(
    oldData,
    newData
) {

    override fun areItemIdentitiesTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem

    override fun areDisplayContentsTheSame(oldItem: String, newItem: String): Boolean =
        oldItem == newItem
}