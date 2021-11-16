package com.tamimattafi.pizza.android.di.modules.ui.dialogs

import com.tamimattafi.pizza.android.di.modules.data.repository.OrdersRepositoryModule
import com.tamimattafi.pizza.android.di.modules.data.repository.PizzaRepositoryModule
import com.tamimattafi.pizza.android.di.modules.data.source.OrdersDataSourceModule
import com.tamimattafi.pizza.android.di.modules.data.source.PizzaDataSourceModule
import com.tamimattafi.pizza.android.di.modules.data.usecase.OrderUseCasesModule
import com.tamimattafi.pizza.android.di.modules.data.usecase.PizzaUseCasesModule
import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.PizzaDetailsDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DialogsModule {

    @ContributesAndroidInjector(modules = [
        PizzaDetailsModule::class,
        PizzaUseCasesModule::class,
        PizzaRepositoryModule::class,
        PizzaDataSourceModule::class,
        OrderUseCasesModule::class,
        OrdersRepositoryModule::class,
        OrdersDataSourceModule::class,
    ])
    fun pizzaDetailsDialog(): PizzaDetailsDialog
}