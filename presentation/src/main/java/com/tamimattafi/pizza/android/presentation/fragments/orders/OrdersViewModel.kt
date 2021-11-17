package com.tamimattafi.pizza.android.presentation.fragments.orders

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.android.presentation.utils.subscribeToProcessor
import com.tamimattafi.pizza.domain.model.order.OrdersTotal
import com.tamimattafi.pizza.domain.usecase.order.*
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import javax.inject.Inject

class OrdersViewModel @Inject constructor(
    orderGetWithTotal: OrderGetWithTotal,
    private val orderAdd: OrderAdd,
    private val orderRemove: OrderRemove,
    private val ordersClear: OrderClear,
    private val orderSubmit: OrderSubmit
) : BaseViewModel() {

    private val ordersListProcessor = BehaviorProcessor.create<OrdersTotal>()
    val ordersListObservable: Flowable<OrdersTotal> get() = ordersListProcessor

    private val errorProcessor = PublishProcessor.create<Unit>()
    val errorObservable: Flowable<Unit> get() = errorProcessor

    private val dismissProcessor = PublishProcessor.create<Unit>()
    val dismissObservable: Flowable<Unit> get() = dismissProcessor

    private val orderSubmitProcessor = PublishProcessor.create<Unit>()
    val orderSubmitObservable: Flowable<Unit> = orderSubmitProcessor

    init {
        orderGetWithTotal().subscribe(ordersListProcessor)
    }

    fun addOrder(pizzaId: Int) {
        orderAdd(pizzaId).subscribeToProcessor(errorProcessor)
    }

    fun removeOrder(pizzaId: Int) {
        orderRemove(pizzaId).subscribeToProcessor(errorProcessor)
    }

    fun clearCart() {
        ordersClear().subscribeToProcessor(dismissProcessor)
    }

    fun placeOrder() {
        orderSubmit().subscribeToProcessor(orderSubmitProcessor)
    }
}