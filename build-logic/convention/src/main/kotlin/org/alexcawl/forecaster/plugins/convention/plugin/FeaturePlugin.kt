package org.alexcawl.forecaster.plugins.convention.plugin

import org.alexcawl.forecaster.plugins.convention.plugin.module.CommonModule
import org.alexcawl.forecaster.plugins.convention.plugin.module.NetworkModule
import org.alexcawl.forecaster.plugins.convention.plugin.module.PersistenceModule
import org.alexcawl.forecaster.plugins.convention.plugin.module.UiModule
import org.alexcawl.forecaster.plugins.core.libs
import org.alexcawl.forecaster.plugins.core.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.android.library.gradle.pluginId)
                apply(CommonModule::class)
                apply(NetworkModule::class)
                apply(PersistenceModule::class)
                apply(UiModule::class)
            }
        }
    }
}