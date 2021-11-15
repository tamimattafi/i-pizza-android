package com.tamimattafi.pizza.domain.usecase.order

import com.tamimattafi.pizza.domain.repository.IOrdersRepository

class OrderSumbit(private val ordersRepository: IOrdersRepository) {
    operator fun invoke() = ordersRepository.submit()
}