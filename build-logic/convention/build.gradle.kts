plugins {
    `kotlin-dsl`
}

dependencies {
    // Workaround: https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(gradleApi())
    implementation(libs.plugin.android.gradle)
    implementation(libs.plugin.android.build.gradle)
    implementation(libs.plugin.kotlin.gradle)
    implementation(libs.plugin.kotlin.serialization.gradle)
    implementation(libs.plugin.ksp.gradle)
    implementation(projects.core)
}

gradlePlugin {
    plugins {
        register("module.application.plugin") {
            id = "module.application.plugin"
            implementationClass = "org.alexcawl.forecaster.plugins.convention.plugin.ApplicationPlugin"
        }

        register("module.feature.plugin") {
            id = "module.feature.plugin"
            implementationClass = "org.alexcawl.forecaster.plugins.convention.plugin.FeaturePlugin"
        }
    }
}