package org.alexcawl.forecaster.feature.settings.di

import org.alexcawl.forecaster.core.common.ComponentHolder
import kotlin.properties.Delegates

object FeatureSettingsComponentHolder : ComponentHolder<FeatureSettingsComponent, FeatureSettingsDependencies> {
    override var dependencies: FeatureSettingsDependencies by Delegates.notNull()

    override val component: FeatureSettingsComponent
        get() = DaggerFeatureSettingsComponent.factory().produce(dependencies)
}
