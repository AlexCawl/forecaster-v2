package org.alexcawl.forecaster.plugins.convention.android

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.JavaVersion

internal val LibrariesForLibs.compileSdk: Int
    get() = this.versions.compileSdk.get().toInt()

internal val LibrariesForLibs.minSdk: Int
    get() = this.versions.minSdk.get().toInt()

internal val LibrariesForLibs.javaVersion: JavaVersion
    get() = JavaVersion.valueOf("VERSION_${this.versions.javaVersion.get()}")
