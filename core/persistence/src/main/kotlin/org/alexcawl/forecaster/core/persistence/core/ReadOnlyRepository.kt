package org.alexcawl.forecaster.core.persistence.core

import kotlinx.coroutines.flow.Flow

interface ReadOnlyRepository<T> {
    val data: Flow<T>
}
