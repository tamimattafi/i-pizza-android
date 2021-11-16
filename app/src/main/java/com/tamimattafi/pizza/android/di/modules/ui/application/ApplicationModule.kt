package com.tamimattafi.pizza.android.di.modules.ui.application

import android.content.Context
import com.tamimattafi.pizza.android.ui.Application
import dagger.Binds
import dagger.Module

@Module
interface ApplicationModule {

    @Binds
    fun bindContext(application: Application): Context
}