package com.tamimattafi.pizza.android.presentation.utils

import androidx.fragment.app.Fragment

fun Fragment.showToastError(throwable: Throwable) {
    requireContext().showToastError(throwable)
}