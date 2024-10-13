package org.alexcawl.forecaster.app

import android.app.Application
import org.alexcawl.forecaster.app.di.ApplicationComponent
import org.alexcawl.forecaster.app.di.DaggerApplicationComponent
import org.alexcawl.forecaster.feature.settings.di.FeatureSettingsComponentHolder

class ForecasterApplication : Application() {
    private var _component: ApplicationComponent? = null
    val component: ApplicationComponent
        get() = _component!!

    override fun onCreate() {
        super.onCreate()
        with(DaggerApplicationComponent.factory().produce(context = this)) {
            _component = this
            FeatureSettingsComponentHolder.dependencies = this
        }
    }
}
