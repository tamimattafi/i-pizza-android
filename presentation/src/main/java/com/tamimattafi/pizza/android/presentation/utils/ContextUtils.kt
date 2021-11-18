package com.tamimattafi.pizza.android.presentation.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes stringId: Int) {
    Toast.makeText(this, stringId, Toast.LENGTH_LONG).show()
}

fun Context.showToastError(throwable: Throwable) {
    val error = throwable.localizedMessage ?: throwable.message ?: throwable.toString()
    Toast.makeText(this, error, Toast.LENGTH_LONG).show()
}