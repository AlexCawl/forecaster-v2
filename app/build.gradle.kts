import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.application.plugin")
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":core:persistence"))
    implementation(project(":feature:settings"))
}

android {
    namespace = moduleNamespace()
}
