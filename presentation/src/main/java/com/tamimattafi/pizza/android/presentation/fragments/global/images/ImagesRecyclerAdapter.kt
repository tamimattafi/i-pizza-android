package com.tamimattafi.pizza.android.presentation.fragments.global.images

import android.view.ViewGroup
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.recycler.SimpleRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.utils.inflate
import javax.inject.Inject

class ImagesRecyclerAdapter @Inject constructor()
    : SimpleRecyclerAdapter<String, ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = parent.inflate(R.layout.holder_image)
        return ImageViewHolder(view)
    }

    override fun bindHolder(holder: ImageViewHolder, item: String) {
        holder.setImageUrl(item)
    }

    override fun createDiffCallback(oldData: List<String>, newData: List<String>)
        = ImagesDiffCallBack(oldData, newData)
}