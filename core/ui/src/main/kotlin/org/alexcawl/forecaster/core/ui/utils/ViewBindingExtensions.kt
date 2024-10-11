package org.alexcawl.forecaster.core.ui.utils

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty

fun <VB : ViewBinding> Fragment.viewBinding(
    viewBindingProducer: (View) -> VB
): ReadOnlyProperty<Fragment, VB> {
    val viewBindingSupplier = { viewBindingProducer(requireView()) }
    return ViewBindingDelegate(lifecycleSupplier, viewBindingSupplier)
}

fun <VB : ViewBinding> AppCompatActivity.viewBinding(
    viewBindingProducer: (View) -> VB
): ReadOnlyProperty<AppCompatActivity, VB> {
    val viewBindingSupplier = { viewBindingProducer(window.decorView.rootView) }
    return ViewBindingDelegate(lifecycleSupplier, viewBindingSupplier)
}

private val Fragment.lifecycleSupplier: () -> LifecycleOwner
    get() = when (this) {
        is DialogFragment -> {
            if (view == null) {
                { this }
            } else {
                { viewLifecycleOwner }
            }
        }

        else -> {
            { viewLifecycleOwner }
        }
    }

private val AppCompatActivity.lifecycleSupplier: () -> LifecycleOwner
    get() = { this }
