package com.tamimattafi.pizza.android.presentation.core.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tamimattafi.pizza.android.presentation.utils.showSnackError
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

abstract class ModelHostFragment<VM : BaseViewModel, VB: ViewBinding>(
    viewModelClass: Class<VM>,
    bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BaseFragment<VB>(bindingBlock) {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

    protected fun <T : Any> Flowable<T>.observe(
        onError: (Throwable) -> Unit = ::handleError,
        onNext: (T) -> Unit = {}
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
}