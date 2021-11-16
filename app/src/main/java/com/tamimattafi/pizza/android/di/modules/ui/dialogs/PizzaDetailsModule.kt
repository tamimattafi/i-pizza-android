package com.tamimattafi.pizza.android.di.modules.ui.dialogs

import androidx.lifecycle.ViewModel
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.PizzaDetailsDialog
import com.tamimattafi.pizza.android.presentation.dialogs.pizza.details.PizzaDetailsViewModel
import com.tamimattafi.pizza.domain.usecase.order.OrderAdd
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGet
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
object PizzaDetailsModule {

    @Provides
    @IntoMap
    @ViewModelKey(PizzaDetailsViewModel::class)
    fun provideViewModel(
        pizzaDetailsDialog: PizzaDetailsDialog,
        pizzaGet: PizzaGet,
        orderAdd: OrderAdd
    ): ViewModel {
        val destination = pizzaDetailsDialog.getDestination<Destination.Dialog.PizzaDetails>()
        return PizzaDetailsViewModel(destination.pizzaId, pizzaGet, orderAdd)
    }
}