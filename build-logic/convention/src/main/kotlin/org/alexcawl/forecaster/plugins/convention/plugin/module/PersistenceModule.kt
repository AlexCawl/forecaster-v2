package org.alexcawl.forecaster.plugins.convention.plugin.module

import org.alexcawl.forecaster.plugins.convention.util.implementation
import org.alexcawl.forecaster.plugins.convention.util.ksp
import org.alexcawl.forecaster.plugins.core.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class PersistenceModule : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(CommonModule::class)
            }
            with(dependencies) {
                implementation(libs.room.core)
                implementation(libs.room.kotlin)
                ksp(libs.room.compiler)
                implementation(libs.preferences)
            }
        }
    }
}