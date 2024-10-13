package org.alexcawl.forecaster.feature.settings.di

import org.alexcawl.forecaster.core.persistence.repository.AvailableSensorsRepository
import org.alexcawl.forecaster.core.persistence.repository.ThemeRepository
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration

interface FeatureSettingsDependencies {
    val viewModelConfiguration: ViewModelConfiguration
    val availableSensorsRepository: AvailableSensorsRepository
    val themeRepository: ThemeRepository
}
