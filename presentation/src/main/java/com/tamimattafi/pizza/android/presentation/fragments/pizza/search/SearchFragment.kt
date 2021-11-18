package com.tamimattafi.pizza.android.presentation.fragments.pizza.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.tamimattafi.pizza.android.presentation.core.mvvm.ModelHostFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.databinding.FragmentSearchBinding
import com.tamimattafi.pizza.android.presentation.fragments.global.pizza.PizzaRecyclerAdapter
import com.tamimattafi.pizza.android.presentation.utils.supportsChangeAnimations
import com.tamimattafi.pizza.domain.model.Pizza
import javax.inject.Inject

class SearchFragment : ModelHostFragment<SearchViewModel, FragmentSearchBinding>(
    SearchViewModel::class.java,
    FragmentSearchBinding::inflate
), PizzaRecyclerAdapter.IEventListener {

    @Inject
    lateinit var recyclerAdapter: PizzaRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpRecyclerView()
        this.setUpListeners()
        this.setUpObservers()
    }

    private fun setUpListeners() {
        viewBinding.fldSearch.addTextChangedListener { newText ->
            viewModel.searchPizza(newText?.toString())
        }
    }

    private fun setUpObservers() {
        viewModel.pizzaListObservable.observe { pizzaList ->
            recyclerAdapter.updateData(pizzaList)
        }
    }

    private fun setUpRecyclerView() = with(viewBinding.recycler) {
        supportsChangeAnimations = false
        adapter = recyclerAdapter
    }

    override fun onItemClick(pizza: Pizza) {
        val detailsDestination = Destination.Dialog.PizzaDetails(pizza.id)
        navigator.openDialog(detailsDestination)
    }
}