package com.tamimattafi.pizza.android.ui.managers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import com.tamimattafi.pizza.domain.utils.IConnectionManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class ConnectionManager @Inject constructor(
    private val context: Context
) : IConnectionManager {

    override val isConnected: Boolean get() {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private var broadcastReceiver: BroadcastReceiver? = null

    override fun listenToConnectionChanges(): Flowable<Boolean> =
        Flowable.create<Boolean>({ emitter ->
            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    emitter.onNext(isConnected)
                }
            }

            val filter = IntentFilter(CONNECTION_CHANGE_ACTION)
            context.registerReceiver(receiver, filter)
            this.broadcastReceiver = receiver
        }, BackpressureStrategy.LATEST).doOnCancel {
            this.broadcastReceiver?.let(context::unregisterReceiver)
            this.broadcastReceiver = null
        }.subscribeOn(AndroidSchedulers.mainThread())

    private companion object {
        const val CONNECTION_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE"
    }
}