package com.tamimattafi.pizza.android.di.modules.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelFactory
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.fragments.menu.MenuFragment
import com.tamimattafi.pizza.android.presentation.fragments.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface MenuModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindViewModel(viewModel: MenuViewModel): ViewModel
}