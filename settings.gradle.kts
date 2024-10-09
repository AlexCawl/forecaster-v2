@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

with(rootProject) {
    name = "forecaster"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// [Applications]
include(
    ":app",
)

// [Core]
include(
    ":core:common",
    ":core:ui",
    ":core:network",
    ":core:persistence",
)

// [Features]
include(
    ":feature",
)
