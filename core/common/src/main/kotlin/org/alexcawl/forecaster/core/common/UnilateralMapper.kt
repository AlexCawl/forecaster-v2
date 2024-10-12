package org.alexcawl.forecaster.core.common

interface UnilateralMapper<T, V> {
    fun map(item: T): V
}
