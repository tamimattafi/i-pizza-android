package com.tamimattafi.pizza.android.presentation.fragments.pizza.gallery

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.android.presentation.utils.subscribeToProcessor
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.usecase.order.OrderAdd
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGet
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor

class GalleryViewModel(
    pizzaId: Int,
    pizzaGet: PizzaGet,
    private val orderAdd: OrderAdd
) : BaseViewModel() {

    private val pizzaProcessor = BehaviorProcessor.create<Pizza>()
    val pizzaObservable: Flowable<Pizza> get() = pizzaProcessor

    private val orderAddProcessor = PublishProcessor.create<Unit>()
    val orderAddObservable: Flowable<Unit> get() = orderAddProcessor

    init {
        pizzaGet(pizzaId).subscribe(pizzaProcessor)
    }

    fun addPizzaToCart() {
        val pizza = requireNotNull(pizzaProcessor.value)
        orderAdd(pizza.id).subscribeToProcessor(orderAddProcessor)
    }
}