package org.alexcawl.forecaster

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.alexcawl.forecaster.app.R
import org.alexcawl.forecaster.app.databinding.ActivityMainBinding
import org.alexcawl.forecaster.core.ui.mvi.BaseActivity
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration
import org.alexcawl.forecaster.core.ui.utils.lazyViewModel
import org.alexcawl.forecaster.core.ui.utils.viewBinding

class MainScreenActivity :
    BaseActivity<MainScreenState, MainScreenAction, ActivityMainBinding>(R.layout.activity_main) {
    override val viewModel: MainScreenViewModel by lazyViewModel<MainScreenViewModel> {
        MainScreenViewModel(
            configuration = object : ViewModelConfiguration {
                override val intentScope: CoroutineScope
                    get() = CoroutineScope(Dispatchers.Main)
                override val intentDispatcher: CoroutineDispatcher
                    get() = Dispatchers.Main
            }
        )
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

    override fun onStart() {
        super.onStart()
        binding.fab.setOnClickListener {
            send(MainScreenAction.NavigateToWeatherScreen)
            send(MainScreenAction.NavigateToLocationsScreen)
        }
    }

    override fun render(state: MainScreenState) {
        println("$state -> ${viewModel.hashCode()}")
    }
}