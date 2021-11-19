package com.tamimattafi.pizza.android.di.modules.ui.application

import android.content.Context
import com.tamimattafi.pizza.android.ui.app.Application
import com.tamimattafi.pizza.android.ui.managers.ConnectionManager
import com.tamimattafi.pizza.domain.utils.IConnectionManager
import dagger.Binds
import dagger.Module

@Module
interface ApplicationModule {

    @Binds
    fun bindContext(application: Application): Context

    @Binds
    fun bindConnectionManager(connectionManager: ConnectionManager): IConnectionManager
}