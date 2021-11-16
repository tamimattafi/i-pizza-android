package com.tamimattafi.pizza.android.di.modules.ui.activities

import com.tamimattafi.pizza.android.di.modules.ui.fragments.FragmentsModule
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelModule
import com.tamimattafi.pizza.android.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        FragmentsModule::class,
        ViewModelModule::class
    ])
    fun mainActivity(): MainActivity
}