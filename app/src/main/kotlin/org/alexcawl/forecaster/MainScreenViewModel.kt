package org.alexcawl.forecaster

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.alexcawl.forecaster.core.ui.mvi.BaseViewModel
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
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
}