package com.tamimattafi.pizza.domain.utils

import io.reactivex.rxjava3.core.Flowable

interface IConnectionManager {
    val isConnected: Boolean
    fun listenToConnectionChanges(): Flowable<Boolean>
}