package org.alexcawl.forecaster.core.ui.mvi

interface UiComponent<S, A> {
    fun send(action: A)

    fun render(state: S)
}