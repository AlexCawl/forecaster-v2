package org.alexcawl.forecaster

sealed interface MainScreenState {
    data object SplashScreenDisplayed : MainScreenState

    data object WeatherScreenDisplayed : MainScreenState

    data object SettingsScreenDisplayed : MainScreenState

    data object LocationsScreenDisplayed : MainScreenState
}
