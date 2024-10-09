package org.alexcawl.forecaster.plugins.convention.plugin.module

import org.alexcawl.forecaster.plugins.convention.android.AndroidExtensions
import org.alexcawl.forecaster.plugins.convention.android.androidConfiguration
import org.alexcawl.forecaster.plugins.convention.android.compileSdk
import org.alexcawl.forecaster.plugins.convention.android.javaVersion
import org.alexcawl.forecaster.plugins.convention.android.minSdk
import org.alexcawl.forecaster.plugins.convention.kotlin.jvmTarget
import org.alexcawl.forecaster.plugins.convention.kotlin.kotlinConfiguration
import org.alexcawl.forecaster.plugins.convention.util.androidTestImplementation
import org.alexcawl.forecaster.plugins.convention.util.implementation
import org.alexcawl.forecaster.plugins.convention.util.ksp
import org.alexcawl.forecaster.plugins.convention.util.testImplementation
import org.alexcawl.forecaster.plugins.core.libs
import org.alexcawl.forecaster.plugins.core.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project

class CommonModule : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.kotlin.android.gradle.pluginId)
                apply(libs.plugins.ksp.gradle.pluginId)
            }
            with(dependencies) {
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.kotlin.coroutines.android)
                testImplementation(libs.junit)
                androidTestImplementation(libs.androidx.junit)
                androidTestImplementation(libs.androidx.espresso.core)
                implementation(libs.dagger.core)
                ksp(libs.dagger.compiler)
            }
            kotlinConfiguration {
                jvmTarget.set(libs.jvmTarget)
            }
            androidConfiguration<AndroidExtensions> {
                compileSdk = libs.compileSdk

                defaultConfig {
                    minSdk = libs.minSdk
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                compileOptions {
                    sourceCompatibility = libs.javaVersion
                    targetCompatibility = libs.javaVersion
                }
            }
        }
    }
}