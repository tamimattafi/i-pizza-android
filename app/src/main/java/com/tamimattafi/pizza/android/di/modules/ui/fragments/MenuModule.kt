package com.tamimattafi.pizza.android.di.modules.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.fragments.pizza.menu.MenuFragment
import com.tamimattafi.pizza.android.presentation.fragments.pizza.global.PizzaRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.fragments.pizza.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MenuModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: MenuFragment): PizzaRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: MenuFragment): ViewModelStoreOwner
}