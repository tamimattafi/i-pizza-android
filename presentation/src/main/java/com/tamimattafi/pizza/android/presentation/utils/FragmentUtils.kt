package com.tamimattafi.pizza.android.presentation.utils

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToastError(throwable: Throwable) {
    requireContext().showToastError(throwable)
}

fun Fragment.showToast(@StringRes stringId: Int) {
    requireContext().showToast(stringId)
}