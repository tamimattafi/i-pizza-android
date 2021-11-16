package com.tamimattafi.pizza.android.presentation.core.mvvm

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.presentation.core.navigation.destinations.FragmentDestination
import com.tamimattafi.pizza.android.presentation.utils.showSnackError
import dagger.android.support.DaggerFragment
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel>(
    @LayoutRes contentLayoutId: Int
) : DaggerFragment(contentLayoutId) {

    abstract val viewModelClass: Class<T>

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    @Inject
    lateinit var navigator: INavigator

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

    fun storeDestination(destination: FragmentDestination) {
        arguments = Bundle().apply {
            putParcelable(DESTINATION_KEY, destination)
        }
    }

    fun <T : FragmentDestination> getDestination(): T?
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