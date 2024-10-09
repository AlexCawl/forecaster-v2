import org.alexcawl.forecaster.plugins.convention.plugin.module.NetworkModule
import org.alexcawl.forecaster.plugins.core.libs
import org.alexcawl.forecaster.plugins.core.pluginId

with(pluginManager) {
    apply(libs.plugins.android.library.gradle.pluginId)
    apply(NetworkModule::class)
}
