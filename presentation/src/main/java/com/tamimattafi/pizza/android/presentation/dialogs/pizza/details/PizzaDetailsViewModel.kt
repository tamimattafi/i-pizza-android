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

    private val orderAddProcessor = PublishProcessor.create<Unit>()
    val orderAddObservable: Flowable<Unit> get() = orderAddProcessor

    private val loadingProcessor = PublishProcessor.create<Boolean>()
    val loadingObservable: Flowable<Boolean> get() = loadingProcessor

    init {
        loadingProcessor.onNext(true)
        pizzaGet(pizzaId)
            .distinctUntilChanged()
            .observeOn(Schedulers.io())
            .doOnNext {
                loadingProcessor.onNext(false)
            }.subscribe(pizzaProcessor)
    }

    fun addPizzaToCart() {
        loadingProcessor.onNext(true)
        val pizza = requireNotNull(pizzaProcessor.value)
        orderAdd(pizza.id).doOnComplete {
            loadingProcessor.onNext(false)
        }.toSingleDefault(Unit)
        .toFlowable()
        .subscribeOn(Schedulers.io())
        .subscribe(orderAddProcessor)
    }
}