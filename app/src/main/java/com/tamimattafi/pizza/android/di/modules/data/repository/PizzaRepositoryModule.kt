package com.tamimattafi.pizza.android.di.modules.data.repository

import com.tamimattafi.pizza.android.data.local.IPizzaLocalDataSource
import com.tamimattafi.pizza.android.data.remote.IPizzaRemoteDataSource
import com.tamimattafi.pizza.android.data.repository.PizzaRepository
import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import dagger.Module
import dagger.Provides

@Module
object PizzaRepositoryModule {

    @Provides
    fun providePizzaRepository(
        local: IPizzaLocalDataSource,
        remote: IPizzaRemoteDataSource
    ): IPizzaRepository = PizzaRepository(
        local,
        remote
    )
}