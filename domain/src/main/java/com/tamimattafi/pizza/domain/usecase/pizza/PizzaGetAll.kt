package com.tamimattafi.pizza.domain.usecase.pizza

import com.tamimattafi.pizza.domain.model.Pizza
import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import io.reactivex.rxjava3.core.Flowable

class PizzaGetAll(private val pizzaRepository: IPizzaRepository) {
    operator fun invoke(): Flowable<List<Pizza>> = pizzaRepository.getAll()
}