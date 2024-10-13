package org.alexcawl.forecaster.core.common

interface ComponentHolder<T, D> {
    var dependencies: D

    val component: T
}
