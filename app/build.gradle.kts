import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.application.plugin")
}

android {
    namespace = moduleNamespace()
}
