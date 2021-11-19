package com.tamimattafi.pizza.android.di.modules.data.repository

import com.tamimattafi.pizza.android.data.local.IOrdersLocalDataSource
import com.tamimattafi.pizza.android.data.remote.IOrdersRemoteDataSource
import com.tamimattafi.pizza.android.data.repository.OrdersRepository
import com.tamimattafi.pizza.domain.repository.IOrdersRepository
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