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

abstract class BaseFragment<VM : BaseViewModel, VB: ViewBinding>(
    viewModelClass: Class<VM>,
    private val bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : DaggerFragment() {

    protected lateinit var viewBinding: VB

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    @Inject
    lateinit var navigator: INavigator

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

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

    protected fun <T : Any> Flowable<T>.observe(
        onError: (Throwable) -> Unit = ::handleError,
        onNext: (T) -> Unit
    ) {
        val observer = LifecycleObserver(
            observable = this,
            onNext,
            onError
        )

        lifecycle.addObserver(observer)
    }

    protected open fun handleError(error: Throwable) {
        this.showSnackError(error)
    }

    private companion object {
        const val DESTINATION_KEY = "destination"
    }
}