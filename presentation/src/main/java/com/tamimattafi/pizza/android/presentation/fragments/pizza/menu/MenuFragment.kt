package com.tamimattafi.pizza.android.presentation.fragments.pizza.menu

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.databinding.FragmentMenuBinding
import com.tamimattafi.pizza.android.presentation.utils.setClickListener
import com.tamimattafi.pizza.domain.model.Pizza
import javax.inject.Inject

class MenuFragment : BaseFragment<MenuViewModel, FragmentMenuBinding>(
    MenuViewModel::class.java,
    FragmentMenuBinding::inflate
), MenuRecyclerAdapter.IEventListener {

    @Inject
    lateinit var recyclerAdapter: MenuRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() = with(viewBinding) {
        btnSearch.setClickListener {
            navigator.openFragment(
                Destination.Fragment.Menu,
                addPreviousToBackStack = true
            )
        }
    }

    private fun setUpObservers() {
        viewModel.pizzaListObservable.observe { pizzaList ->
            recyclerAdapter.updateData(pizzaList)
        }
    }

    private fun setUpRecyclerView() {
        viewBinding.recycler.adapter = recyclerAdapter
    }

    override fun onItemClick(pizza: Pizza) {
        val detailsDestination = Destination.Dialog.PizzaDetails(pizza.id)
        navigator.openDialog(detailsDestination)
    }
}