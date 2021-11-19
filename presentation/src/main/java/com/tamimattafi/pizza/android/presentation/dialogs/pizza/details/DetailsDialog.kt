package com.tamimattafi.pizza.android.presentation.dialogs.pizza.details

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.mvvm.ModelHostBottomSheet
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination.Dialog.Details
import com.tamimattafi.pizza.android.presentation.databinding.DialogPizzaDetailsBinding
import com.tamimattafi.pizza.android.presentation.utils.beautifyDouble
import com.tamimattafi.pizza.android.presentation.utils.setClickListener

class DetailsDialog : ModelHostBottomSheet<DetailsViewModel, DialogPizzaDetailsBinding, Details>(
    DetailsViewModel::class.java,
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

        orderAddObservable.observe {
            dismiss()
        }

        galleryOpenObservable.observe { pizza ->
            val destination = Destination.Fragment.Gallery(pizza.id)
            navigator.openFragment(destination)
            dismiss()
        }
    }

    private fun setUpListeners() = with(viewBinding) {
        btnAddToCart.setClickListener(viewModel::addPizzaToCart)
        imgPizza.setClickListener(viewModel::openGallery)
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

    private fun setPrice(price: Double) {
        val formattedPrice = price.beautifyDouble()
        viewBinding.txtPrice.text = requireContext().getString(
            R.string.price_template,
            formattedPrice
        )
    }
}