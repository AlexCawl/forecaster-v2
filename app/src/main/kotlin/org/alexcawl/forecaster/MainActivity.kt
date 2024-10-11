package org.alexcawl.forecaster

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.alexcawl.forecaster.app.R
import org.alexcawl.forecaster.app.databinding.ActivityMainBinding
import org.alexcawl.forecaster.core.ui.mvi.BaseActivity
import org.alexcawl.forecaster.core.ui.mvi.BaseViewModel
import org.alexcawl.forecaster.core.ui.mvi.ViewModelConfiguration
import org.alexcawl.forecaster.core.ui.utils.viewBinding

class MainActivity : BaseActivity<Unit, Unit, ActivityMainBinding>(R.layout.activity_main) {
    override val viewModel: BaseViewModel<Unit, Unit>
        get() = object : BaseViewModel<Unit, Unit>(
            configuration = object : ViewModelConfiguration {
                override val intentScope: CoroutineScope
                    get() = CoroutineScope(Dispatchers.Main)
                override val intentDispatcher: CoroutineDispatcher
                    get() = Dispatchers.Main
            },
            initialState = Unit
        ) {
            override fun handle(action: Unit) {
                println(Unit)
            }
        }

    override val binding: ActivityMainBinding by viewBinding {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun renderState(state: Unit) {
        println("Hello world")
    }
}