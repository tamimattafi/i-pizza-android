package com.tamimattafi.pizza.android.di.modules.ui.fragments

import com.tamimattafi.pizza.android.di.modules.data.repository.PizzaRepositoryModule
import com.tamimattafi.pizza.android.di.modules.data.source.PizzaDataSourceModule
import com.tamimattafi.pizza.android.di.modules.data.source.local.PrimaryDatabaseModule
import com.tamimattafi.pizza.android.di.modules.data.usecase.PizzaUseCasesModule
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelModule
import com.tamimattafi.pizza.android.presentation.fragments.menu.MenuFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector(modules = [
        MenuModule::class,
        PizzaUseCasesModule::class,
        PizzaRepositoryModule::class,
        PizzaDataSourceModule::class
    ])
    fun menuFragment(): MenuFragment
}