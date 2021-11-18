package com.tamimattafi.pizza.android.di.modules.ui.dialogs

import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.DetailsDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface DialogsModule {

    @ContributesAndroidInjector(modules = [DetailsModule::class])
    fun pizzaDetailsDialog(): DetailsDialog
}