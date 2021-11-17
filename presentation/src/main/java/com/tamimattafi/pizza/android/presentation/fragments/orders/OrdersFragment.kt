package com.tamimattafi.pizza.android.presentation.fragments.orders

import android.os.Bundle
import android.view.View
import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.databinding.FragmentOrdersBinding
import com.tamimattafi.pizza.android.presentation.utils.setClickListener
import com.tamimattafi.pizza.domain.model.order.Order
import javax.inject.Inject

class OrdersFragment : BaseFragment<OrdersViewModel, FragmentOrdersBinding>(
    OrdersViewModel::class.java,
    FragmentOrdersBinding::inflate
), OrdersRecyclerAdapter.IEventListener {

    @Inject
    lateinit var recyclerAdapter: OrdersRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() = with(viewBinding) {
        btnClear.setClickListener(viewModel::clearCart)
        btnPlaceOrder.setClickListener(viewModel::placeOrder)
    }

    private fun setUpObservers() = with(viewModel) {
        ordersListObservable.observe { ordersTotal ->
            recyclerAdapter.updateData(ordersTotal.orders)
            //TODO: use price format and rouble sign
            viewBinding.txtPrice.text = ordersTotal.totalPrice.toString()
        }

        dismissObservable.observe {
            navigator.openFragment(
                Destination.Fragment.Menu,
                addPreviousToBackStack = false
            )
        }

        orderSubmitObservable.observe {
            //TODO: open order complete fragment
        }

        errorObservable.observe()
    }

    private fun setUpRecyclerView() = with(viewBinding.recycler) {
        itemAnimator = null
        adapter = recyclerAdapter
    }

    override fun onItemClick(order: Order) {
        val detailsDestination = Destination.Dialog.PizzaDetails(order.pizza.id)
        navigator.openDialog(detailsDestination)
    }

    override fun onAddClick(order: Order) {
        viewModel.addOrder(order.pizza.id)
    }

    override fun onRemoveClick(order: Order) {
        viewModel.removeOrder(order.pizza.id)
    }
}