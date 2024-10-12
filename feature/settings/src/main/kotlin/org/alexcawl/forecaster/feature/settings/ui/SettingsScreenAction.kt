package org.alexcawl.forecaster.feature.settings.ui

import org.alexcawl.forecaster.core.persistence.entity.Theme

sealed interface SettingsScreenAction {
    data class SetTheme(val theme: Theme) : SettingsScreenAction

    data object NavigateBack : SettingsScreenAction
}
