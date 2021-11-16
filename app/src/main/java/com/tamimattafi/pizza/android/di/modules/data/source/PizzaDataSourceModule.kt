package com.tamimattafi.pizza.android.di.modules.data.source

import com.tamimattafi.pizza.android.data.local.IPizzaLocalDataSource
import com.tamimattafi.pizza.android.data.local.data.PizzaLocalDataSource
import com.tamimattafi.pizza.android.data.local.database.dao.IPizzaDao
import com.tamimattafi.pizza.android.data.remote.IPizzaRemoteDataSource
import com.tamimattafi.pizza.android.data.remote.client.pizza.IPizzaClient
import com.tamimattafi.pizza.android.data.remote.data.PizzaRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
object PizzaDataSourceModule {

    @Provides
    fun provideLocalDataSource(dao: IPizzaDao): IPizzaLocalDataSource =
        PizzaLocalDataSource(dao)

    @Provides
    fun provideRemoteDataSource(client: IPizzaClient): IPizzaRemoteDataSource =
        PizzaRemoteDataSource(client)
}