package com.tamimattafi.pizza.android.di.modules.ui.fragments.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.fragments.orders.cart.CartFragment
import com.tamimattafi.pizza.android.presentation.fragments.orders.cart.CartRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.fragments.orders.cart.CartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface CartModule {

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    fun bindViewModel(viewModel: CartViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: CartFragment): CartRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: CartFragment): ViewModelStoreOwner
}