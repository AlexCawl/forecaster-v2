package org.alexcawl.forecaster.plugins.convention.plugin.module

import org.alexcawl.forecaster.plugins.convention.util.implementation
import org.alexcawl.forecaster.plugins.core.libs
import org.alexcawl.forecaster.plugins.core.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class NetworkModule : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(CommonModule::class)
                apply(libs.plugins.kotlin.serialization.gradle.pluginId)
            }
            with(dependencies) {
                implementation(libs.kotlin.serialization.core)
                implementation(libs.kotlin.serialization.json)
                implementation(libs.ktor.client)
                implementation(libs.ktor.serialization)
            }
        }
    }
}