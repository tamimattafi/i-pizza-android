package com.tamimattafi.pizza.android.presentation.dialogs.alerts

import android.os.Bundle
import android.view.View
import com.tamimattafi.pizza.android.presentation.core.navigation.Destination
import com.tamimattafi.pizza.android.presentation.core.screens.BaseBottomSheet
import com.tamimattafi.pizza.android.presentation.databinding.DialogConfirmationBinding
import com.tamimattafi.pizza.android.presentation.utils.setClickListener

class ConfirmationDialog : BaseBottomSheet<
        DialogConfirmationBinding,
        Destination.Dialog.Confirmation
>(DialogConfirmationBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Avoid parsing destination twice from bundle
        val destination = this.destination
        this.setUpViews(destination)
        this.setUpListeners(destination)
    }

    private fun setUpViews(destination: Destination.Dialog.Confirmation) = with(viewBinding) {
        txtLabel.text = destination.label
        btnNegative.text = destination.negativeLabel
        btnPositive.text = destination.positiveLabel
    }

    private fun setUpListeners(destination: Destination.Dialog.Confirmation) = with(viewBinding) {
        btnPositive.setClickListener {
            destination.onPositive()
            dismiss()
        }

        btnNegative.setClickListener {
            destination.onNegative?.invoke()
            dismiss()
        }
    }
}