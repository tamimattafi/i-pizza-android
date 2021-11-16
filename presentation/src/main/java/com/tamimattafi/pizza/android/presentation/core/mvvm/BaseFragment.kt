package com.tamimattafi.pizza.android.presentation.core.mvvm

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

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
}