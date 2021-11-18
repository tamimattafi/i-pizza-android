package com.tamimattafi.pizza.android.presentation.fragments.pizza.menu

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.usecase.order.OrderGetTotal
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGetAll
import com.tamimattafi.pizza.domain.utils.IConnectionManager
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val pizzaGetAll: PizzaGetAll,
    ordersGetTotal: OrderGetTotal,
    connectionManager: IConnectionManager
) : BaseViewModel() {

    private val pizzaListProcessor = BehaviorProcessor.create<List<Pizza>>()
    val pizzaListObservable: Flowable<List<Pizza>> get() = pizzaListProcessor

    private val totalPriceProcessor = BehaviorProcessor.create<Double>()
    val totalPriceObservable: Flowable<Double> get() = totalPriceProcessor

    private val connectionProcessor = BehaviorProcessor.create<Boolean>()
    val connectionObservable: Flowable<Boolean> get() = connectionProcessor

    init {
        ordersGetTotal().subscribe(totalPriceProcessor)
        connectionManager.listenToConnectionChanges().subscribe(connectionProcessor)
    }

    fun updateMenuData() {
        pizzaGetAll().subscribe(pizzaListProcessor)
    }
}