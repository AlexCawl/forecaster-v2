@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

with(rootProject) {
    name = "build-logic"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// [Modules]
include(
    ":core",
    ":convention"
)