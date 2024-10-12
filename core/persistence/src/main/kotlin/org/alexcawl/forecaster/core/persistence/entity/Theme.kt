package org.alexcawl.forecaster.core.persistence.entity

sealed interface Theme {
    data object System : Theme

    data object Day : Theme

    data object Night : Theme
}