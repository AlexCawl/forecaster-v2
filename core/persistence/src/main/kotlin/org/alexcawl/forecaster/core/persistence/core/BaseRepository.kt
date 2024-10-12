package org.alexcawl.forecaster.core.persistence.core

import kotlinx.coroutines.flow.Flow

interface BaseRepository<T> : ReadOnlyRepository<T> {
    override val data: Flow<T>

    suspend fun set(value: T)
}
