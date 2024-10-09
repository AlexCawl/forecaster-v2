import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.common.plugin")
}

android {
    namespace = moduleNamespace()
}
