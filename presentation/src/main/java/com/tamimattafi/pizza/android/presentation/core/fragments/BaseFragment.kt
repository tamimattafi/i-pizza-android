package com.tamimattafi.pizza.android.presentation.core.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : DaggerFragment() {

    protected lateinit var viewBinding: VB

    @Inject
    lateinit var navigator: INavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = bindingBlock.invoke(inflater, container, false)
        return viewBinding.root
    }

    fun storeDestination(destination: Destination.Fragment) {
        arguments = Bundle().apply {
            putParcelable(DESTINATION_KEY, destination)
        }
    }

    fun <T : Destination.Fragment> getDestination(): T {
        val destination = requireArguments().getParcelable<T>(DESTINATION_KEY)
        return requireNotNull(destination)
    }

    private companion object {
        const val DESTINATION_KEY = "destination"
    }
}