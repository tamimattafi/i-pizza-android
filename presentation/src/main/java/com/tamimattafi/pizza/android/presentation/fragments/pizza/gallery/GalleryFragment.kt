package com.tamimattafi.pizza.android.presentation.fragments.pizza.gallery

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.mvvm.ModelHostFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.databinding.FragmentGalleryBinding
import com.tamimattafi.pizza.android.presentation.fragments.global.images.ImagesRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.utils.addPageChangeListener
import com.tamimattafi.pizza.android.presentation.utils.beautifyDouble
import com.tamimattafi.pizza.android.presentation.utils.setClickListener
import javax.inject.Inject

class GalleryFragment : ModelHostFragment<GalleryViewModel, FragmentGalleryBinding>(
    GalleryViewModel::class.java,
    FragmentGalleryBinding::inflate
) {

    @Inject
    lateinit var imagesAdapter: ImagesRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpViewPager()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpViewPager() {
        viewBinding.pager.adapter = imagesAdapter
    }

    private fun setUpObservers() = with(viewModel) {
        pizzaObservable.observe { pizza ->
            setName(pizza.name)
            setPrice(pizza.price)

            imagesAdapter.updateData(pizza.imageUrls)
            updateSelectedItem(viewBinding.pager.currentItem)
        }

        orderAddObservable.observe {
            navigator.toDirection(Destination.Direction.Back)
        }
    }

    private fun setUpListeners() = with(viewBinding) {
        btnAddToCart.setClickListener {
            viewModel.addPizzaToCart()
        }

        btnBack.setClickListener {
            navigator.toDirection(Destination.Direction.Back)
        }

        pager.addPageChangeListener(::updateSelectedItem)
    }

    private fun updateSelectedItem(position: Int) = with(viewBinding) {
        val currentItemPosition = position + 1
        viewBinding.txtQuantity.text = getString(
            R.string.gallery_item_count_template,
            currentItemPosition,
            imagesAdapter.itemCount
        )
    }

    private fun setName(name: String) {
        viewBinding.txtTitle.text = name
    }

    private fun setPrice(price: Double) {
        val formattedPrice = price.beautifyDouble()
        viewBinding.txtPrice.text = requireContext().getString(
            R.string.price_template,
            formattedPrice
        )
    }
}