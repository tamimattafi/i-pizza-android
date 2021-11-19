package com.tamimattafi.pizza.android.di.modules.ui.dialogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.DetailsDialog
import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.DetailsViewModel
import com.tamimattafi.pizza.domain.usecase.order.OrderAdd
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGet
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface DetailsModule {

    @Binds
    fun bindModelStoreOwner(dialog: DetailsDialog): ViewModelStoreOwner

    companion object {

        @Provides
        @IntoMap
        @ViewModelKey(DetailsViewModel::class)
        fun provideViewModel(
            pizzaDetailsDialog: DetailsDialog,
            pizzaGet: PizzaGet,
            orderAdd: OrderAdd
        ): ViewModel {
            val destination = pizzaDetailsDialog.destination
            return DetailsViewModel(destination.pizzaId, pizzaGet, orderAdd)
        }
    }
}