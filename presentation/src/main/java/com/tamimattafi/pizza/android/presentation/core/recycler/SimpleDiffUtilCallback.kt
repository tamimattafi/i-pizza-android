package com.tamimattafi.pizza.android.presentation.core.recycler

import androidx.recyclerview.widget.DiffUtil

abstract class SimpleDiffUtilCallback<T>(
    private val oldData: List<T>,
    private val newData: List<T>
) : DiffUtil.Callback() {

    abstract fun areItemIdentitiesTheSame(oldItem: T, newItem: T): Boolean

    abstract fun areDisplayContentsTheSame(oldItem: T, newItem: T): Boolean

    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return this.handleItemsComparing(
            oldItemPosition,
            newItemPosition,
            this::areItemIdentitiesTheSame
        )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return this.handleItemsComparing(
            oldItemPosition,
            newItemPosition,
            this::areDisplayContentsTheSame
        )
    }

    private fun handleItemsComparing(
        oldItemPosition: Int,
        newItemPosition: Int,
        comparator: (T, T) -> Boolean
    ): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]

        return comparator.invoke(oldItem, newItem)
    }
}