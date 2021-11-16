package com.tamimattafi.pizza.android.presentation.fragments.menu

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGetAll
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.PublishProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    pizzaGetAll: PizzaGetAll
) : BaseViewModel() {

    private val pizzaListProcessor = PublishProcessor.create<List<Pizza>>()
    val pizzaListObservable: Flowable<List<Pizza>> get() = pizzaListProcessor

    init {
        pizzaGetAll()
            .subscribeOn(Schedulers.io())
            .distinctUntilChanged()
            .subscribe(pizzaListProcessor)
    }
}