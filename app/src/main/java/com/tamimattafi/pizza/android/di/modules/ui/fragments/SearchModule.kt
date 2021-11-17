package com.tamimattafi.pizza.android.di.modules.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.fragments.pizza.global.PizzaRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.fragments.pizza.search.SearchFragment
import com.tamimattafi.pizza.android.presentation.fragments.pizza.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: SearchFragment): PizzaRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: SearchFragment): ViewModelStoreOwner
}