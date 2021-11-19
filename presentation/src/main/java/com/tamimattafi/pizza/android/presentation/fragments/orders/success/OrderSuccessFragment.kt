package com.tamimattafi.pizza.android.presentation.fragments.orders.success

import android.os.Bundle
import android.view.View
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination.Fragment.OrderSuccess
import com.tamimattafi.pizza.android.presentation.core.screens.BaseFragment
import com.tamimattafi.pizza.android.presentation.databinding.FragmentOrderSuccessBinding
import com.tamimattafi.pizza.android.presentation.utils.setClickListener

class OrderSuccessFragment : BaseFragment<FragmentOrderSuccessBinding, OrderSuccess>(
    FragmentOrderSuccessBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpListeners()
    }

    private fun setUpListeners() = with(viewBinding) {
        btnMenu.setClickListener {
            navigator.toDirection(Destination.Direction.Back)
        }
    }
}