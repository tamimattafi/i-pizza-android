package com.tamimattafi.pizza.android.di.components

import com.tamimattafi.pizza.android.di.modules.data.source.local.PrimaryDatabaseModule
import com.tamimattafi.pizza.android.di.modules.data.source.remote.PrimaryClientModule
import com.tamimattafi.pizza.android.di.modules.ui.activities.ActivitiesModule
import com.tamimattafi.pizza.android.di.modules.ui.application.ApplicationModule
import com.tamimattafi.pizza.android.ui.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,
    ApplicationModule::class,
    ActivitiesModule::class,
    PrimaryDatabaseModule::class,
    PrimaryClientModule::class
])
interface ApplicationComponent : AndroidInjector<Application> {

    override fun inject(instance: Application)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(instance: Application): Builder

        fun build(): ApplicationComponent
    }
}