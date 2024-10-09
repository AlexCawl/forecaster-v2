package org.alexcawl.forecaster.plugins.convention.util

import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider

internal fun DependencyHandler.implementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("implementation", dependency)
}

internal fun DependencyHandler.testImplementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("testImplementation", dependency)
}

internal fun DependencyHandler.androidTestImplementation(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("androidTestImplementation", dependency)
}

internal fun DependencyHandler.ksp(
    dependency: Provider<MinimalExternalModuleDependency>
) {
    add("ksp", dependency)
}
