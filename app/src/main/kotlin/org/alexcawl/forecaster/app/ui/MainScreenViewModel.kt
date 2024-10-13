package org.alexcawl.forecaster.app.ui

import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.alexcawl.forecaster.core.ui.mvi.BaseViewModel
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration

class MainScreenViewModel @AssistedInject constructor(
    configuration: ViewModelConfiguration
) : BaseViewModel<MainScreenState, MainScreenAction>(
    configuration = configuration,
    initialState = MainScreenState.SplashScreenDisplayed
) {
    init {
        viewModelScope.launch {
            delay(3000)
            task {
                reduce {
                    MainScreenState.SettingsScreenDisplayed
                }
            }
        }
    }

    override fun handle(action: MainScreenAction) = when (action) {
        MainScreenAction.NavigateToLocationsScreen -> task {
            reduce {
                MainScreenState.LocationsScreenDisplayed
            }
        }
        MainScreenAction.NavigateToSettingsScreen -> task {
            reduce {
                MainScreenState.SettingsScreenDisplayed
            }
        }
        MainScreenAction.NavigateToWeatherScreen -> task {
            reduce {
                MainScreenState.WeatherScreenDisplayed
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): MainScreenViewModel
    }
}
