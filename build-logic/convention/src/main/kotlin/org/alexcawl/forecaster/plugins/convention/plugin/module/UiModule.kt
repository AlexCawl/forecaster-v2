package org.alexcawl.forecaster.plugins.convention.plugin.module

import org.alexcawl.forecaster.plugins.convention.android.AndroidExtensions
import org.alexcawl.forecaster.plugins.convention.android.androidConfiguration
import org.alexcawl.forecaster.plugins.convention.util.implementation
import org.alexcawl.forecaster.plugins.core.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class UiModule : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(CommonModule::class)
            }
            with(dependencies) {
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)
                implementation(libs.androidx.constraintlayout)
                implementation(libs.material)
            }
            androidConfiguration<AndroidExtensions> {
                buildFeatures {
                    viewBinding = true
                }
            }
        }
    }
}