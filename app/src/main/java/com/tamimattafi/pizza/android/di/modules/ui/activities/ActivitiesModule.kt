package com.tamimattafi.pizza.android.di.modules.ui.activities

import com.tamimattafi.pizza.android.di.modules.data.repository.OrdersRepositoryModule
import com.tamimattafi.pizza.android.di.modules.data.repository.PizzaRepositoryModule
import com.tamimattafi.pizza.android.di.modules.data.source.OrdersDataSourceModule
import com.tamimattafi.pizza.android.di.modules.data.source.PizzaDataSourceModule
import com.tamimattafi.pizza.android.di.modules.data.usecase.OrderUseCasesModule
import com.tamimattafi.pizza.android.di.modules.data.usecase.PizzaUseCasesModule
import com.tamimattafi.pizza.android.di.modules.ui.dialogs.DialogsModule
import com.tamimattafi.pizza.android.di.modules.ui.fragments.FragmentsModule
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelModule
import com.tamimattafi.pizza.android.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        FragmentsModule::class,
        DialogsModule::class,
        ViewModelModule::class,
        OrderUseCasesModule::class,
        OrdersRepositoryModule::class,
        OrdersDataSourceModule::class,
        PizzaUseCasesModule::class,
        PizzaRepositoryModule::class,
        PizzaDataSourceModule::class
    ])
    fun mainActivity(): MainActivity
}