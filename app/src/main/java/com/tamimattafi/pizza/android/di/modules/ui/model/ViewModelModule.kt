package com.tamimattafi.pizza.android.di.modules.ui.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
interface ViewModelModule {

    @Binds
    @Reusable
    fun bindFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    companion object {

        @Provides
        fun provideViewModelProvider(
            factory: ViewModelProvider.Factory,
            viewModelStoreOwner: ViewModelStoreOwner
        ): ViewModelProvider = ViewModelProvider(viewModelStoreOwner, factory)
    }
}