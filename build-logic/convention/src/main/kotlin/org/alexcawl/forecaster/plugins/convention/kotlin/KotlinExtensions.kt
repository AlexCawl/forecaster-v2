package org.alexcawl.forecaster.plugins.convention.kotlin

import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal val LibrariesForLibs.jvmTarget: JvmTarget
    get() = JvmTarget.fromTarget(this.versions.jvmTarget.get())
