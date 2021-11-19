package com.tamimattafi.pizza.android.presentation.utils

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToastError(throwable: Throwable) {
    requireContext().showToastError(throwable)
}

fun Fragment.showToast(@StringRes stringId: Int) {
    requireContext().showToast(stringId)
}

fun Fragment.provideArguments(): Bundle {
    if (arguments == null) {
        arguments = Bundle()
    }

    return requireNotNull(arguments)
}