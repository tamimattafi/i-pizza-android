package com.tamimattafi.pizza.android.presentation.fragments.menu

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tamimattafi.pizza.android.presentation.R
import com.tamimattafi.pizza.android.presentation.core.mvvm.BaseFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.FragmentDestination
import com.tamimattafi.pizza.android.presentation.databinding.FragmentMenuBinding
import com.tamimattafi.pizza.android.presentation.utils.setClickListener
import javax.inject.Inject

class MenuFragment : BaseFragment<MenuViewModel>(R.layout.fragment_menu) {

    override val viewModelClass: Class<MenuViewModel> = MenuViewModel::class.java

    @Inject
    lateinit var recyclerAdapter: MenuRecyclerAdapter

    private val viewBinding by viewBinding(FragmentMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() {
        viewBinding.btnSearch.setClickListener {
            navigator.openFragment(
                FragmentDestination.Menu,
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
}