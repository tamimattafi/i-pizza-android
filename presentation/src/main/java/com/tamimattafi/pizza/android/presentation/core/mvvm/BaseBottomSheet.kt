package com.tamimattafi.pizza.android.presentation.core.mvvm

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.presentation.utils.showToastError
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

abstract class BaseBottomSheet<VM : BaseViewModel, VB: ViewBinding>(
    viewModelClass: Class<VM>,
    private val bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
)  : BottomSheetDialogFragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any?>

    @Inject
    lateinit var viewModelProvider: ViewModelProvider

    @Inject
    lateinit var navigator: INavigator

    protected open val isFullScreen: Boolean = true

    protected lateinit var viewBinding: VB

    protected val viewModel by lazy {
        viewModelProvider[viewModelClass]
    }

    @CallSuper
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = bindingBlock.invoke(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener(::onDialogShow)
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }

    final override fun androidInjector(): AndroidInjector<Any?> = androidInjector

    fun storeDestination(destination: Destination.Dialog) {
        arguments = Bundle().apply {
            putParcelable(DESTINATION_KEY, destination)
        }
    }

    fun <T : Destination.Dialog> getDestination(): T {
        val destination = requireArguments().getParcelable<T>(DESTINATION_KEY)
        return requireNotNull(destination)
    }

    protected open fun onDialogShow(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        bottomSheetDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        if (isFullScreen) {
            bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
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
        this.showToastError(error)
    }

    private companion object {
        const val DESTINATION_KEY = "destination"
    }
}