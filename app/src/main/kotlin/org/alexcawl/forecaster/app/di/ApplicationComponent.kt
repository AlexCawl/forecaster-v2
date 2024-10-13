package org.alexcawl.forecaster.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.alexcawl.forecaster.app.ui.MainScreenViewModel
import org.alexcawl.forecaster.feature.settings.di.FeatureSettingsDependencies


@ApplicationScope
@Component(
    modules = [ApplicationModule::class],
)
interface ApplicationComponent : FeatureSettingsDependencies {
    @Component.Factory
    interface Factory {
        fun produce(@BindsInstance context: Context): ApplicationComponent
    }

    val mainScreenViewModelFactory: MainScreenViewModel.Factory
}
