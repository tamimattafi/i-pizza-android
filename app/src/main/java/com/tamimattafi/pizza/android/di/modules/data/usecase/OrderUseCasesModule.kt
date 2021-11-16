package com.tamimattafi.pizza.android.di.modules.data.usecase

import com.tamimattafi.pizza.domain.repository.IOrdersRepository
import com.tamimattafi.pizza.domain.usecase.order.OrderAdd
import dagger.Module
import dagger.Provides

@Module
object OrderUseCasesModule {

    @Provides
    fun provideAddUseCase(repository: IOrdersRepository) =
        OrderAdd(repository)
}