package com.tamimattafi.pizza.android.presentation.utils

import java.math.RoundingMode
import java.text.NumberFormat
import java.util.*

const val FIAT_MAX_DECIMALS = 2

fun Double.beautifyDouble(
    decimals: Int = FIAT_MAX_DECIMALS,
    locale: Locale = Locale.US
): String = NumberFormat.getInstance(locale).apply {
    maximumFractionDigits = decimals
    roundingMode = RoundingMode.DOWN
}.format(this)