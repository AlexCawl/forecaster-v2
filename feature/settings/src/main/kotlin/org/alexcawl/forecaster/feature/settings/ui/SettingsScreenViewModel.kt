package org.alexcawl.forecaster.feature.settings.ui

import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import org.alexcawl.forecaster.core.ui.mvi.BaseViewModel
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration
import org.alexcawl.forecaster.feature.settings.domain.GetAvailableSensorsUseCase
import org.alexcawl.forecaster.feature.settings.domain.GetThemeUseCase
import org.alexcawl.forecaster.feature.settings.domain.SetThemeUseCase

class SettingsScreenViewModel @AssistedInject constructor(
    configuration: ViewModelConfiguration,
    private val getSensors: GetAvailableSensorsUseCase,
    private val getTheme: GetThemeUseCase,
    private val setTheme: SetThemeUseCase,
) : BaseViewModel<SettingsScreenState, SettingsScreenAction>(
    configuration = configuration,
    initialState = SettingsScreenState.Loading
) {
    init {
        viewModelScope.launch {
            delay(1000)
            task {
                getSensors().combine(getTheme()) { sensors, theme ->
                    reduce {
                        SettingsScreenState.Base(
                            availableSensors = sensors,
                            theme = theme
                        )
                    }
                }.collect()
            }
        }
    }

    override fun handle(action: SettingsScreenAction) = when (action) {
        is SettingsScreenAction.NavigateBack -> task {
            println("Dude...")
        }
        is SettingsScreenAction.SetTheme -> task {
            setTheme(action.theme)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): SettingsScreenViewModel
    }
}
