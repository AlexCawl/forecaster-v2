package org.alexcawl.forecaster.plugins.core

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.the
import org.gradle.plugin.use.PluginDependency

val Project.libs: LibrariesForLibs
    get() = this.the<LibrariesForLibs>()

val Provider<PluginDependency>.pluginId: String
    get() = this.get().pluginId

fun Project.moduleNamespace(moduleName: String? = null): String {
    val baseNamespace = libs.versions.applicationId.get()
    val name = moduleName ?: path.removePrefix(":").replace(":", ".")
    return "$baseNamespace.$name"
}
