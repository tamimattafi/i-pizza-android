package com.tamimattafi.pizza.android.presentation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(
    @LayoutRes layoutId: Int,
    attachToRoot: Boolean = false
): View = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun View.setClickListener(onClick: () -> Unit) = setOnClickListener {
    onClick()
}