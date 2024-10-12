package org.alexcawl.forecaster

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import org.alexcawl.forecaster.app.R
import org.alexcawl.forecaster.app.databinding.ActivityMainBinding
import org.alexcawl.forecaster.core.ui.mvi.BaseActivity
import org.alexcawl.forecaster.core.ui.utils.BaseViewModelConfiguration
import org.alexcawl.forecaster.core.ui.utils.lazyViewModel
import org.alexcawl.forecaster.core.ui.utils.viewBinding
import org.alexcawl.forecaster.feature.settings.ui.SettingsScreenFragment

class MainScreenActivity : BaseActivity<MainScreenState, MainScreenAction, ActivityMainBinding>() {
    override val viewModel: MainScreenViewModel by lazyViewModel<MainScreenViewModel> {
        MainScreenViewModel(configuration = BaseViewModelConfiguration())
    }

    override val binding: ActivityMainBinding by viewBinding {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val screen = installSplashScreen()
        super.onCreate(savedInstanceState)
        screen.setKeepOnScreenCondition {
            viewModel.state.value == MainScreenState.SplashScreenDisplayed
        }
    }

    override fun render(state: MainScreenState) {
        println("$state -> ${viewModel.hashCode()}")
        when (state) {
            MainScreenState.SplashScreenDisplayed -> Unit
            MainScreenState.WeatherScreenDisplayed -> TODO()
            MainScreenState.LocationsScreenDisplayed -> TODO()
            MainScreenState.SettingsScreenDisplayed -> {
                println("Here")
                supportFragmentManager.commit {
                    replace<SettingsScreenFragment>(R.id.fragmentContainerView)
                }
            }
        }
    }
}