package com.tamimattafi.pizza.android.presentation.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.shape.MaterialShapeDrawable

import android.R
import android.widget.FrameLayout
import androidx.annotation.StyleRes
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.shape.ShapeAppearanceModel

import org.jetbrains.annotations.NotNull
import androidx.core.view.ViewCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback


fun ViewGroup.inflate(
    @LayoutRes layoutId: Int,
    attachToRoot: Boolean = false
): View = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun View.setClickListener(onClick: () -> Unit) = setOnClickListener {
    onClick()
}

fun BottomSheetBehavior<FrameLayout>.addStateChangeListener(
    onStateChanged: (bottomSheet: View, newState: Int) -> Unit
) = addBottomSheetCallback(
    object : BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            onStateChanged(bottomSheet, newState)
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {}
    }
)


fun View.createMaterialShapeDrawable(
    @StyleRes style: Int
): MaterialShapeDrawable {
    val shapeAppearanceModel = ShapeAppearanceModel.builder(
        context,
        0,
        style
    ).build()

    val currentMaterialShapeDrawable = background as MaterialShapeDrawable
    return MaterialShapeDrawable(shapeAppearanceModel).apply {
        initializeElevationOverlay(context)
        fillColor = currentMaterialShapeDrawable.fillColor
        tintList = currentMaterialShapeDrawable.tintList
        elevation = currentMaterialShapeDrawable.elevation
        strokeWidth = currentMaterialShapeDrawable.strokeWidth
        strokeColor = currentMaterialShapeDrawable.strokeColor
    }
}