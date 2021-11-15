package com.tamimattafi.pizza.domain.usecase

import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import io.reactivex.rxjava3.core.Flowable

class PizzaGetAll(private val repository: IPizzaRepository) {
    operator fun invoke(): Flowable<List<Pizza>> = repository.getAll()
}