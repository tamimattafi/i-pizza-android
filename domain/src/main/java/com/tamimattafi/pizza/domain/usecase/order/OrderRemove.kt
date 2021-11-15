package com.tamimattafi.pizza.domain.usecase.order

import com.tamimattafi.pizza.domain.repository.IOrdersRepository

class OrderRemove(private val ordersRepository: IOrdersRepository) {
    operator fun invoke(pizzaId: Int) = ordersRepository.remove(pizzaId)
}