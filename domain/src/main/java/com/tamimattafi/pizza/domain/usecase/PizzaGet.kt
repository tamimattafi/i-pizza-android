package com.tamimattafi.pizza.domain.usecase

import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import io.reactivex.rxjava3.core.Flowable

class PizzaGet(private val repository: IPizzaRepository) {
    operator fun invoke(id: Int): Flowable<Pizza> = repository.get(id)
}