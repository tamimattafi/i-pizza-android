package com.tamimattafi.pizza.android.presentation.core.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.presentation.utils.showSnackError
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Flowable
import java.util.zip.Inflater
import javax.inject.Inject

abstract class BaseFragment<VB: ViewBinding>(
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

    fun <T : Destination.Fragment> getDestination(): T?
            = requireArguments().getParcelable(DESTINATION_KEY) as? T

    private companion object {
        const val DESTINATION_KEY = "destination"
    }
}