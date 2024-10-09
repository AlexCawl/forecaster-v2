import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.feature.plugin")
}

android {
    namespace = moduleNamespace("feature")
}
