package com.tamimattafi.pizza.android.presentation.dialogs.pizza.details

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.usecase.order.OrderAdd
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGet
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import io.reactivex.rxjava3.schedulers.Schedulers

class PizzaDetailsViewModel(
    pizzaId: Int,
    pizzaGet: PizzaGet,
    private val orderAdd: OrderAdd
) : BaseViewModel() {

    private val pizzaProcessor = BehaviorProcessor.create<Pizza>()
    val pizzaObservable: Flowable<Pizza> get() = pizzaProcessor

    private val dismissProcessor = PublishProcessor.create<Unit>()
    val dismissObservable: Flowable<Unit> get() = dismissProcessor

    init {
        pizzaGet(pizzaId)
            .distinctUntilChanged()
            .observeOn(Schedulers.io())
            .subscribe(pizzaProcessor)
    }

    fun addPizzaToCart() {
        val pizza = requireNotNull(pizzaProcessor.value)
        orderAdd(pizza.id)
            .toSingleDefault(Unit)
            .toFlowable()
            .subscribeOn(Schedulers.io())
            .subscribe(dismissProcessor)
    }
}