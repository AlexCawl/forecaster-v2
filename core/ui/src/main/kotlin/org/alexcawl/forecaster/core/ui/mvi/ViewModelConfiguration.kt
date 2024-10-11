package org.alexcawl.forecaster.core.ui.mvi

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface ViewModelConfiguration {
    val intentScope: CoroutineScope
    val intentDispatcher: CoroutineDispatcher
}