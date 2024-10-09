import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.ui.plugin")
}

android {
    namespace = moduleNamespace()
}
