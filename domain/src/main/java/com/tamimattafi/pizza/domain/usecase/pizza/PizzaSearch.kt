package com.tamimattafi.pizza.domain.usecase.pizza

import com.tamimattafi.pizza.domain.repository.IPizzaRepository

class PizzaSearch(private val pizzaRepository: IPizzaRepository) {
    operator fun invoke(query: String? = null) = pizzaRepository.search(query)
}