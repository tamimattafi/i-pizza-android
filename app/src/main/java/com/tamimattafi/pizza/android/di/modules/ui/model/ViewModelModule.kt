package com.tamimattafi.pizza.android.di.modules.ui.model

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface ViewModelModule {

    @Binds
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindModelStoreOwner(owner: AppCompatActivity): ViewModelStoreOwner

    companion object {

        @Provides
        fun provideViewModelProvider(
            factory: ViewModelProvider.Factory,
            viewModelStoreOwner: ViewModelStoreOwner
        ): ViewModelProvider = ViewModelProvider(viewModelStoreOwner, factory)
    }
}