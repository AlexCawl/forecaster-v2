package org.alexcawl.forecaster

sealed interface MainScreenAction {
    data object NavigateToWeatherScreen : MainScreenAction

    data object NavigateToSettingsScreen : MainScreenAction

    data object NavigateToLocationsScreen : MainScreenAction
}