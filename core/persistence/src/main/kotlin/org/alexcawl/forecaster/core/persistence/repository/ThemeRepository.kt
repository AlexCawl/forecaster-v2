package org.alexcawl.forecaster.core.persistence.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.alexcawl.forecaster.core.persistence.core.BaseRepository
import org.alexcawl.forecaster.core.common.BilateralMapper
import org.alexcawl.forecaster.core.persistence.entity.Theme

class ThemeRepository(
    private val dataStore: DataStore<Preferences>
) : BaseRepository<Theme>, BilateralMapper<String, Theme> {
    override val data: Flow<Theme> = dataStore.data
        .map { preferences -> preferences[key] ?: defaultValue }
        .map(::mapFrom)

    override suspend fun set(value: Theme) {
        dataStore.edit { preferences ->
            preferences[key] = mapTo(value)
        }
    }

    override fun mapFrom(item: String): Theme = when (item) {
        "system" -> Theme.System
        "day" -> Theme.Day
        "night" -> Theme.Night
        else -> error("Invalid theme value: $this")
    }

    override fun mapTo(item: Theme): String = when (item) {
        Theme.System -> "system"
        Theme.Day -> "day"
        Theme.Night -> "night"
    }

    @Suppress("ConstPropertyName")
    private companion object {
        const val keyName: String = "theme"
        const val defaultValue: String = "system"
        val key: Preferences.Key<String> = stringPreferencesKey(keyName)
    }
}
