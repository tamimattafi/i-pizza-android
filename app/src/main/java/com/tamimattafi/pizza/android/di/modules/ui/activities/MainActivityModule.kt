package com.tamimattafi.pizza.android.di.modules.ui.activities

import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.ui.activities.MainActivity
import dagger.Binds
import dagger.Module

@Module
interface MainActivityModule {

    @Binds
    fun bindNavigator(activity: MainActivity): INavigator
}