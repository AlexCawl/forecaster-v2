package org.alexcawl.forecaster.core.ui.mvi

typealias StateReduction<S> = suspend ((S) -> S) -> Unit

data class StateContext<S>(
    val reduce: StateReduction<S>
)
