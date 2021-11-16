package com.tamimattafi.pizza.android.di.modules.data.usecase

import com.tamimattafi.pizza.domain.repository.IPizzaRepository
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGet
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGetAll
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaSearch
import dagger.Module
import dagger.Provides

@Module
object PizzaUseCasesModule {

    @Provides
    fun provideGetUseCase(repository: IPizzaRepository) =
        PizzaGet(repository)

    @Provides
    fun provideGetAllUseCase(repository: IPizzaRepository) =
        PizzaGetAll(repository)

    @Provides
    fun provideSearchUseCase(repository: IPizzaRepository) =
        PizzaSearch(repository)
}