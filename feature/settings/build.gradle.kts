import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.feature.plugin")
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":core:persistence"))
}

android {
    namespace = moduleNamespace()
}
