import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.network.plugin")
}

dependencies {
    implementation(project(":core:common"))
}

android {
    namespace = moduleNamespace()
}
