package com.tamimattafi.pizza.domain.usecase.order

import com.tamimattafi.pizza.domain.repository.IOrdersRepository

class OrderClear(private val repository: IOrdersRepository) {
    operator fun invoke() = repository.clear()
}