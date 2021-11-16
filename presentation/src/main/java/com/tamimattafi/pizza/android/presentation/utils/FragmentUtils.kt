package com.tamimattafi.pizza.android.presentation.utils

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackError(throwable: Throwable) {
    val error = throwable.localizedMessage ?: throwable.message ?: throwable.toString()
    val view = requireView()
    Snackbar.make(view, error, Snackbar.LENGTH_LONG).show()
}