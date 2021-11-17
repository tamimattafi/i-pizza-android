package com.tamimattafi.pizza.android.di.modules.ui.fragments

import com.tamimattafi.pizza.android.di.modules.ui.fragments.orders.OrdersModule
import com.tamimattafi.pizza.android.di.modules.ui.fragments.pizza.MenuModule
import com.tamimattafi.pizza.android.di.modules.ui.fragments.pizza.SearchModule
import com.tamimattafi.pizza.android.presentation.fragments.orders.OrdersFragment
import com.tamimattafi.pizza.android.presentation.fragments.pizza.menu.MenuFragment
import com.tamimattafi.pizza.android.presentation.fragments.pizza.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector(modules = [MenuModule::class])
    fun menuFragment(): MenuFragment

    @ContributesAndroidInjector(modules = [SearchModule::class])
    fun searchFragment(): SearchFragment

    @ContributesAndroidInjector(modules = [OrdersModule::class])
    fun ordersFragment(): OrdersFragment
}