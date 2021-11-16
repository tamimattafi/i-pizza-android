package com.tamimattafi.pizza.android.presentation.fragments.pizza.menu

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGetAll
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.processors.PublishProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    pizzaGetAll: PizzaGetAll
) : BaseViewModel() {

    private val pizzaListProcessor = BehaviorProcessor.create<List<Pizza>>()
    val pizzaListObservable: Flowable<List<Pizza>> get() = pizzaListProcessor

    init {
        pizzaGetAll()
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .subscribe(pizzaListProcessor)
    }
}