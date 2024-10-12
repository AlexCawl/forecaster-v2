package org.alexcawl.forecaster.feature.settings.ui

import org.alexcawl.forecaster.core.persistence.entity.SensorInfo
import org.alexcawl.forecaster.core.persistence.entity.Theme

sealed interface SettingsScreenState {
    data object Loading : SettingsScreenState

    data class Base(
        val availableSensors: List<SensorInfo>,
        val theme: Theme
    ) : SettingsScreenState
}
