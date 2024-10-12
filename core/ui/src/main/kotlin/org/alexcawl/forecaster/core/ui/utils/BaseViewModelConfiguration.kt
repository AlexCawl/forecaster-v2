package org.alexcawl.forecaster.core.ui.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration

class BaseViewModelConfiguration : ViewModelConfiguration {
    override val intentScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)
    override val intentDispatcher: CoroutineDispatcher
        get() = Dispatchers.Main
}
