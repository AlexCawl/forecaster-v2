package org.alexcawl.forecaster.core.common

interface Consumer<in A> {
    fun consume(action: A)
}
