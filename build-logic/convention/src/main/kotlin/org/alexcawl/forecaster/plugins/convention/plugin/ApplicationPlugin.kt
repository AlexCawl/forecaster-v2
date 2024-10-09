package org.alexcawl.forecaster.plugins.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import org.alexcawl.forecaster.plugins.convention.android.androidConfiguration
import org.alexcawl.forecaster.plugins.convention.plugin.module.CommonModule
import org.alexcawl.forecaster.plugins.convention.plugin.module.NetworkModule
import org.alexcawl.forecaster.plugins.convention.plugin.module.PersistenceModule
import org.alexcawl.forecaster.plugins.convention.plugin.module.UiModule
import org.alexcawl.forecaster.plugins.core.libs
import org.alexcawl.forecaster.plugins.core.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class ApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.android.application.gradle.pluginId)
                apply(CommonModule::class)
                apply(NetworkModule::class)
                apply(PersistenceModule::class)
                apply(UiModule::class)
            }
            androidConfiguration<ApplicationExtension> {
                defaultConfig {
                    versionCode = 1
                    versionName = "1.0.0"
                }

                buildTypes {
                    getByName("debug") {
                        isMinifyEnabled = false
                        applicationIdSuffix = ".debug"
                        isDebuggable = true
                    }

                    getByName("release") {
                        isMinifyEnabled = true
                        multiDexEnabled = true
                        isShrinkResources = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
                        )
                    }
                }
            }
        }
    }
}