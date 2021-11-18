package com.tamimattafi.pizza.android.ui.app

import com.tamimattafi.pizza.android.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.plugins.RxJavaPlugins

class Application : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        this.observeUncaughtErrors()
    }

    private fun observeUncaughtErrors() {
        RxJavaPlugins.setErrorHandler(Throwable::printStackTrace)
    }
}