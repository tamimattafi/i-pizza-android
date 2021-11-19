package com.tamimattafi.pizza.android.di.modules.data.source

import com.tamimattafi.pizza.android.data.local.IOrdersLocalDataSource
import com.tamimattafi.pizza.android.data.local.data.OrdersLocalDataSource
import com.tamimattafi.pizza.android.data.local.database.dao.IOrdersDao
import com.tamimattafi.pizza.android.data.remote.IOrdersRemoteDataSource
import com.tamimattafi.pizza.android.data.remote.client.order.IOrderClient
import com.tamimattafi.pizza.android.data.remote.data.OrdersRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
object OrdersDataSourceModule {

    @Provides
    fun provideLocalDataSource(dao: IOrdersDao): IOrdersLocalDataSource =
        OrdersLocalDataSource(dao)

    @Provides
    fun provideRemoteDataSource(client: IOrderClient): IOrdersRemoteDataSource =
        OrdersRemoteDataSource(client)
}