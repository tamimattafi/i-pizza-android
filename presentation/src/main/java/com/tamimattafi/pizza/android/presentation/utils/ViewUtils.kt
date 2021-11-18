package com.tamimattafi.pizza.android.presentation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewpager2.widget.ViewPager2

fun ViewGroup.inflate(
    @LayoutRes layoutId: Int,
    attachToRoot: Boolean = false
): View = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun View.setClickListener(onClick: () -> Unit) = setOnClickListener {
    onClick()
}

fun ViewPager2.addPageChangeListener(onPageChange: (position: Int) -> Unit) =
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            onPageChange(position)
        }
    })