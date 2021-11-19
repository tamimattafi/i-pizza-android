package com.tamimattafi.pizza.android.presentation.core.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.presentation.utils.provideArguments
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding, D: Destination.Fragment>(
    private val bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : DaggerFragment() {

    @Inject
    lateinit var navigator: INavigator

    var destination: D
        set(value) {
            provideArguments().putParcelable(DESTINATION_KEY, value)
        }
        get() {
            val destination = requireArguments().getParcelable<D>(DESTINATION_KEY)
            return requireNotNull(destination)
        }

    protected lateinit var viewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = bindingBlock.invoke(inflater, container, false)
        return viewBinding.root
    }

    @Suppress("UNCHECKED_CAST")
    fun forceStoreDestination(destination: Destination.Fragment) {
        this.destination = destination as D
    }

    private companion object {
        const val DESTINATION_KEY = "destination"
    }
}