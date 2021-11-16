package com.tamimattafi.pizza.android.di.modules.data.repository

import com.tamimattafi.pizza.android.data.local.IOrdersLocalDataSource
import com.tamimattafi.pizza.android.data.local.IPizzaLocalDataSource
import com.tamimattafi.pizza.android.data.remote.IOrdersRemoteDataSource
import com.tamimattafi.pizza.android.data.remote.IPizzaRemoteDataSource
import com.tamimattafi.pizza.android.data.repository.OrdersRepository
import com.tamimattafi.pizza.android.data.repository.PizzaRepository
import com.tamimattafi.pizza.domain.repository.IOrdersRepository
import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import dagger.Module
import dagger.Provides

@Module
object OrdersRepositoryModule {

    @Provides
    fun provideOrdersRepository(
        local: IOrdersLocalDataSource,
        remote: IOrdersRemoteDataSource
    ): IOrdersRepository = OrdersRepository(
        local,
        remote
    )
}