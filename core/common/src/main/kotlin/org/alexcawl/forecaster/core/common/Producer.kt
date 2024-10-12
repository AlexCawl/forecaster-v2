package org.alexcawl.forecaster.core.common

import kotlinx.coroutines.flow.StateFlow

interface Producer<out S> {
    val state: StateFlow<S>
}
