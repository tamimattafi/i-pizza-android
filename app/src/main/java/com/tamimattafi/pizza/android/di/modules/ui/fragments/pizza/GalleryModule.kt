package com.tamimattafi.pizza.android.di.modules.ui.fragments.pizza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.tamimattafi.pizza.android.di.modules.ui.model.ViewModelKey
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.fragments.pizza.gallery.GalleryViewModel
import com.tamimattafi.pizza.android.presentation.fragments.pizza.gallery.GalleryFragment
import com.tamimattafi.pizza.domain.usecase.order.OrderAdd
import com.tamimattafi.pizza.domain.usecase.pizza.PizzaGet
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface GalleryModule {

    @Binds
    fun bindModelStoreOwner(fragment: GalleryFragment): ViewModelStoreOwner

    companion object {

        @Provides
        @IntoMap
        @ViewModelKey(GalleryViewModel::class)
        fun provideViewModel(
            pizzaDetailsDialog: GalleryFragment,
            pizzaGet: PizzaGet,
            orderAdd: OrderAdd
        ): ViewModel {
            val destination = pizzaDetailsDialog
                .getDestination<Destination.Fragment.Gallery>()

            return GalleryViewModel(destination.pizzaId, pizzaGet, orderAdd)
        }
    }
}