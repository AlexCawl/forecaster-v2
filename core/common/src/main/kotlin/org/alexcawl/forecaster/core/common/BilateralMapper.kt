package org.alexcawl.forecaster.core.common

interface BilateralMapper<T, V> {
    fun mapFrom(item: T): V

    fun mapTo(item: V): T
}
