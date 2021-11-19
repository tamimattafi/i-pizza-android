package com.tamimattafi.pizza.android.presentation.core.recycler

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleRecyclerAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    private var data = emptyList<T>()

    abstract fun bindHolder(holder: VH, item: T)
    abstract fun createDiffCallback(oldData: List<T>, newData: List<T>): DiffUtil.Callback

    final override fun onBindViewHolder(holder: VH, position: Int) {
        val item = data[position]
        this.bindHolder(holder, item)
    }

    final override fun getItemCount(): Int = data.size

    fun updateData(newData: List<T>) {
        val diffCallback = this.createDiffCallback(data, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.data = newData
        diffResult.dispatchUpdatesTo(this)
    }
}