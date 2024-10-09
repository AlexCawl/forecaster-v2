import org.alexcawl.forecaster.plugins.core.moduleNamespace

plugins {
    id("module.persistence.plugin")
}

android {
    namespace = moduleNamespace()
}
