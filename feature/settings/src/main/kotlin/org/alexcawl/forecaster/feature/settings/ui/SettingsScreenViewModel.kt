package org.alexcawl.forecaster.feature.settings.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.alexcawl.forecaster.core.persistence.entity.SensorInfo
import org.alexcawl.forecaster.core.persistence.entity.Theme
import org.alexcawl.forecaster.core.ui.mvi.BaseViewModel
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration
import javax.inject.Inject

class SettingsScreenViewModel @Inject constructor(
    configuration: ViewModelConfiguration
) : BaseViewModel<SettingsScreenState, SettingsScreenAction>(
    configuration = configuration,
    initialState = SettingsScreenState.Loading
) {
    init {
        viewModelScope.launch {
            delay(3000)
            task {
                reduce {
                    SettingsScreenState.Base(
                        listOf(
                            SensorInfo("a", "b", 1),
                        ),
                        Theme.System
                    )
                }
            }
        }
    }

    override fun handle(action: SettingsScreenAction) {
        TODO("Not yet implemented")
    }
}
