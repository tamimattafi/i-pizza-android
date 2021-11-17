package com.tamimattafi.pizza.android.di.modules.ui.fragments

import com.tamimattafi.pizza.android.di.modules.ui.fragments.orders.CartModule
import com.tamimattafi.pizza.android.di.modules.ui.fragments.pizza.MenuModule
import com.tamimattafi.pizza.android.di.modules.ui.fragments.pizza.SearchModule
import com.tamimattafi.pizza.android.presentation.fragments.orders.cart.CartFragment
import com.tamimattafi.pizza.android.presentation.fragments.orders.success.OrderSuccessFragment
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

    @ContributesAndroidInjector(modules = [CartModule::class])
    fun cartFragment(): CartFragment

    @ContributesAndroidInjector
    fun orderSuccessFragment(): OrderSuccessFragment
}