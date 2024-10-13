package org.alexcawl.forecaster.feature.settings.di

import dagger.Component
import org.alexcawl.forecaster.feature.settings.ui.SettingsScreenViewModel

@FeatureSettingsScope
@Component(
    modules = [FeatureSettingsModule::class],
    dependencies = [FeatureSettingsDependencies::class]
)
interface FeatureSettingsComponent {
    @Component.Factory
    interface Factory {
        fun produce(dependencies: FeatureSettingsDependencies): FeatureSettingsComponent
    }

    val settingsScreenViewModelFactory: SettingsScreenViewModel.Factory
}
