package org.alexcawl.forecaster.feature.settings.ui.adapter

import org.alexcawl.forecaster.core.persistence.entity.SensorInfo
import org.alexcawl.forecaster.core.persistence.entity.Theme

sealed interface SettingsItem {
    data class TitleItem(val title: String) : SettingsItem

    data class SensorItem(val sensorInfo: SensorInfo) : SettingsItem

    data class ThemeItem(val theme: Theme) : SettingsItem
}
