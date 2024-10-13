package org.alexcawl.forecaster.app.di

import android.content.Context
import android.hardware.SensorManager
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration
import org.alexcawl.forecaster.core.ui.utils.BaseViewModelConfiguration
import kotlin.properties.Delegates

@Module
interface ApplicationModule {
    companion object {
        @Provides
        fun provideViewModelConfiguration(): ViewModelConfiguration = BaseViewModelConfiguration()

        @Provides
        fun provideSensorManager(context: Context): SensorManager {
            return context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        }

        private val Context.dataStore by preferencesDataStore("forecaster_prefs")

        @Provides
        fun provideDatastore(context: Context): DataStore<Preferences> = context.dataStore
    }
}
