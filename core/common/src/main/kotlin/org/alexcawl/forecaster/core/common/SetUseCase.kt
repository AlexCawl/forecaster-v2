package org.alexcawl.forecaster.core.common

interface SetUseCase<T> {
    suspend operator fun invoke(value: T)
}
