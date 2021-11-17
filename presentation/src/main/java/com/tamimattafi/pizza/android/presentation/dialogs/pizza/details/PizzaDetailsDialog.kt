package com.tamimattafi.pizza.android.presentation.dialogs.pizza.details

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.bumptech.glide.Glide
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseBottomSheet
import com.tamimattafi.pizza.android.presentation.databinding.DialogPizzaDetailsBinding
import com.tamimattafi.pizza.android.presentation.utils.setClickListener

class PizzaDetailsDialog : BaseBottomSheet<PizzaDetailsViewModel, DialogPizzaDetailsBinding>(
    PizzaDetailsViewModel::class.java,
    DialogPizzaDetailsBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpObservers() = with(viewModel) {
        pizzaObservable.observe { pizza ->
            setName(pizza.name)
            setDescription(pizza.description)

            val firstImage = pizza.imageUrls.first()
            setImageUrl(firstImage)
            setPrice(pizza.price)
        }

        dismissObservable.observe {
            dismiss()
        }

        loadingObservable.observe { isLoading ->
            viewBinding.progressLoading.isGone = !isLoading
            viewBinding.layerData.isInvisible = isLoading
        }
    }

    private fun setUpListeners() {
        viewBinding.btnAddToCart.setClickListener {
            viewModel.addPizzaToCart()
        }
    }

    private fun setName(name: String) {
        viewBinding.txtName.text = name
    }

    private fun setDescription(description: String) {
        viewBinding.txtDescription.text = description
    }

    private fun setImageUrl(imageUrl: String) {
        Glide.with(viewBinding.imgPizza)
            .load(imageUrl)
            .placeholder(R.drawable.background_primary)
            .into(viewBinding.imgPizza)
    }

    fun setPrice(price: Double) {
        //TODO: format and use rouble sign

    }
}