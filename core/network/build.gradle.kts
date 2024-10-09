import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.network.plugin")
}

android {
    namespace = moduleNamespace()
}
