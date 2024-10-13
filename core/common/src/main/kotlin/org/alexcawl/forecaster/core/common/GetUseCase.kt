package org.alexcawl.forecaster.core.common

import kotlinx.coroutines.flow.Flow

interface GetUseCase<T> {
    operator fun invoke(): Flow<T>
}
