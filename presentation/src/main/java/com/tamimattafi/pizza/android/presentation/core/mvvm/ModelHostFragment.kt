package com.tamimattafi.pizza.android.presentation.core.mvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.screens.BaseFragment
import com.tamimattafi.pizza.android.presentation.utils.observe
import com.tamimattafi.pizza.android.presentation.utils.showToastError
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

abstract class ModelHostFragment<VM : BaseViewModel, VB: ViewBinding, D: Destination.Fragment>(
    viewModelClass: Class<VM>,
    bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BaseFragment<VB, D>(bindingBlock) {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

    protected fun <T : Any> Flowable<T>.observe(
        onError: (Throwable) -> Unit = ::handleError,
        onNext: (T) -> Unit = {}
    ) {
        observe(this, onError, onNext)
    }

    protected open fun handleError(error: Throwable) {
        this.showToastError(error)
    }
}