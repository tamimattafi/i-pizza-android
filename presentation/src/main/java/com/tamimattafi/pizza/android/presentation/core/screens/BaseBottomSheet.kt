package com.tamimattafi.pizza.android.presentation.core.screens

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
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.navigation.INavigator
import com.tamimattafi.pizza.android.presentation.utils.provideArguments
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseBottomSheet<VB : ViewBinding, D : Destination.Dialog>(
    private val bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : BottomSheetDialogFragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any?>

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

    protected open val isFullScreen: Boolean = true

    protected lateinit var viewBinding: VB

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

    @Suppress("UNCHECKED_CAST")
    fun forceStoreDestination(destination: Destination.Dialog) {
        this.destination = destination as D
    }

    protected open fun onDialogShow(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        bottomSheetDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        if (isFullScreen) {
            bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    private companion object {
        const val DESTINATION_KEY = "destination"
    }
}