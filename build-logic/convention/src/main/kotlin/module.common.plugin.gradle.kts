import org.alexcawl.forecaster.plugins.convention.plugin.module.CommonModule
import org.alexcawl.forecaster.plugins.core.libs
import org.alexcawl.forecaster.plugins.core.pluginId
import org.gradle.kotlin.dsl.apply

with(pluginManager) {
    apply(libs.plugins.android.library.gradle.pluginId)
    apply(CommonModule::class)
}
