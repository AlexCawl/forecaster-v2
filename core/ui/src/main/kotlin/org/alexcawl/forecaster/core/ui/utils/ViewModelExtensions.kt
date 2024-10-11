package org.alexcawl.forecaster.core.ui.utils

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

inline fun <reified VM : ViewModel> Fragment.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> VM
): Lazy<VM> = viewModels<VM> {
    BaseViewModelFactory(
        savedStateRegistryOwner = this,
        creator = create
    )
}

inline fun <reified VM : ViewModel> ComponentActivity.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> VM
): Lazy<VM> = viewModels<VM> {
    BaseViewModelFactory(
        savedStateRegistryOwner = this,
        creator = create
    )
}
