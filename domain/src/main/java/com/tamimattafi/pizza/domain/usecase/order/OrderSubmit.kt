package com.tamimattafi.pizza.domain.usecase.order

import com.tamimattafi.pizza.domain.repository.IOrdersRepository

class OrderSubmit(private val ordersRepository: IOrdersRepository) {
    operator fun invoke() = ordersRepository.submit()
}