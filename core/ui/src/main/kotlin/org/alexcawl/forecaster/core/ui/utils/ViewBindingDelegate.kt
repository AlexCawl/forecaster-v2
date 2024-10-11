package org.alexcawl.forecaster.core.ui.utils

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal class ViewBindingDelegate<in T, out VB : ViewBinding>(
    private val lifecycleSupplier: () -> LifecycleOwner,
    private val viewBindingSupplier: () -> VB
) : ReadOnlyProperty<T, VB> {
    private var viewBinding: VB? = null

    private val lifecycleObserver = object : DefaultLifecycleObserver {
        private val mainHandler = Handler(Looper.getMainLooper())

        override fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)
            if (!mainHandler.post { resetViewBinding() }) {
                resetViewBinding()
            }
        }
    }

    private fun resetViewBinding() {
        checkIsMainThread()
        viewBinding = null
    }

    override fun getValue(thisRef: T, property: KProperty<*>): VB {
        checkIsMainThread()

        val binding = viewBinding
        return if (binding != null) {
            binding
        } else {
            val lifecycle = lifecycleSupplier().lifecycle
            if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
                throw IllegalStateException("Binding is unavailable, view already destroyed.")
            }
            lifecycle.addObserver(lifecycleObserver)
            viewBindingSupplier().also { this.viewBinding = it }
        }
    }

    private fun checkIsMainThread() = check(
        value = Looper.myLooper() == Looper.getMainLooper(),
        lazyMessage = { "Trying attempt access to binding in background thread " }
    )
}