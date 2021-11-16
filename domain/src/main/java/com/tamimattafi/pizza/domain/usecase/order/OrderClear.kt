package com.tamimattafi.pizza.domain.usecase.order

import com.tamimattafi.pizza.domain.repository.IOrdersRepository

class OrderClear(private val ordersRepository: IOrdersRepository) {
    operator fun invoke() = ordersRepository.clear()
}