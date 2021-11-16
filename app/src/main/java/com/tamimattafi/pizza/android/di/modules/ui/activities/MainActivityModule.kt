package com.tamimattafi.pizza.android.di.modules.ui.activities

import androidx.appcompat.app.AppCompatActivity
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.ui.activities.MainActivity
import dagger.Binds
import dagger.Module

@Module
interface MainActivityModule {

    @Binds
    fun bindActivity(activity: MainActivity): AppCompatActivity

    @Binds
    fun bindNavigator(activity: MainActivity): INavigator
}