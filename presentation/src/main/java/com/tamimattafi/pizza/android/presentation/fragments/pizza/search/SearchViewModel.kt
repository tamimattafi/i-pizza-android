package com.tamimattafi.pizza.android.presentation.fragments.pizza.search

import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseViewModel
import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaSearch
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val pizzaSearch: PizzaSearch
) : BaseViewModel() {

    private val pizzaListProcessor = BehaviorProcessor.create<List<Pizza>>()
    val pizzaListObservable: Flowable<List<Pizza>> get() = pizzaListProcessor

    init {
        this.searchPizza(query = null)
    }

    fun searchPizza(query: String?) {
        pizzaSearch(query)
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .subscribe(pizzaListProcessor)
    }
}