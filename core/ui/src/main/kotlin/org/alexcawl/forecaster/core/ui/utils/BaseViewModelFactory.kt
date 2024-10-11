package org.alexcawl.forecaster.core.ui.utils

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

@Suppress("UNCHECKED_CAST")
class BaseViewModelFactory<T : ViewModel>(
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val creator: (stateHandle: SavedStateHandle) -> T
) : AbstractSavedStateViewModelFactory(
    owner = savedStateRegistryOwner,
    defaultArgs = null
) {
    override fun <VM : ViewModel> create(
        key: String,
        modelClass: Class<VM>,
        handle: SavedStateHandle
    ): VM = creator.invoke(handle) as VM
}
