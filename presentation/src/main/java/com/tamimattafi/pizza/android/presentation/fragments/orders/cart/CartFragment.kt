package com.tamimattafi.pizza.android.presentation.fragments.orders.cart

import android.os.Bundle
import android.view.View
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.mvvm.ModelHostFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination.Fragment.Cart
import com.tamimattafi.pizza.android.presentation.databinding.FragmentCartBinding
import com.tamimattafi.pizza.android.presentation.utils.beautifyDouble
import com.tamimattafi.pizza.android.presentation.utils.setClickListener
import com.tamimattafi.pizza.android.presentation.utils.supportsChangeAnimations
import com.tamimattafi.pizza.domain.model.order.Order
import javax.inject.Inject

class CartFragment : ModelHostFragment<CartViewModel, FragmentCartBinding, Cart>(
    CartViewModel::class.java,
    FragmentCartBinding::inflate
), CartRecyclerAdapter.IEventListener {

    @Inject
    lateinit var recyclerAdapter: CartRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() = with(viewBinding) {
        btnClear.setClickListener {
            val destination = Destination.Dialog.Confirmation(
                getString(R.string.clear_cart_warning_label),
                getString(R.string.common_yes),
                getString(R.string.common_close),
                viewModel::clearCart
            )

            navigator.openDialog(destination)
        }

        btnPlaceOrder.setClickListener(viewModel::placeOrder)
    }

    private fun setUpObservers() = with(viewModel) {
        ordersListObservable.observe { ordersTotal ->
            if (ordersTotal.orders.isEmpty()) {
                navigator.toDirection(Destination.Direction.Back)
                return@observe
            }

            recyclerAdapter.updateData(ordersTotal.orders)

            val formattedPrice = ordersTotal.totalPrice.beautifyDouble()
            viewBinding.txtPrice.text = requireContext().getString(
                R.string.price_template,
                formattedPrice
            )
        }

        clearCartObservable.observe {
            navigator.toDirection(Destination.Direction.Back)
        }

        orderSubmitObservable.observe {
            navigator.openFragment(
                Destination.Fragment.OrderSuccess,
                addPreviousToBackStack = false
            )
        }

        errorObservable.observe()
    }

    private fun setUpRecyclerView() = with(viewBinding.recycler) {
        supportsChangeAnimations = false
        adapter = recyclerAdapter
    }

    override fun onItemClick(order: Order) {
        val detailsDestination = Destination.Dialog.Details(order.pizza.id)
        navigator.openDialog(detailsDestination)
    }

    override fun onAddClick(order: Order) {
        viewModel.addOrder(order.pizza.id)
    }

    override fun onRemoveClick(order: Order) {
        val newQuantity = order.quantity - Order.Defaults.DEFAULT_QUANTITY_STEP
        if (newQuantity == Order.Defaults.MIN_QUANTITY) {
            val destination = Destination.Dialog.Confirmation(
                getString(R.string.remove_order_warning_label),
                getString(R.string.common_yes),
                getString(R.string.common_close),
                { viewModel.removeOrder(order.pizza.id) }
            )

            navigator.openDialog(destination)
        } else {
            viewModel.removeOrder(order.pizza.id)
        }
    }
}