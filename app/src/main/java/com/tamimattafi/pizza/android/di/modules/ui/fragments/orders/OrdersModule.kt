package com.tamimattafi.pizza.android.di.modules.ui.fragments.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.fragments.orders.OrdersFragment
import com.tamimattafi.pizza.android.presentation.fragments.orders.OrdersRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.fragments.orders.OrdersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface OrdersModule {

    @Binds
    @IntoMap
    @ViewModelKey(OrdersViewModel::class)
    fun bindViewModel(viewModel: OrdersViewModel): ViewModel

    @Binds
    fun bindEventListener(fragment: OrdersFragment): OrdersRecyclerAdapter.IEventListener

    @Binds
    fun bindModelStoreOwner(fragment: OrdersFragment): ViewModelStoreOwner
}