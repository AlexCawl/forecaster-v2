package org.alexcawl.forecaster.core.ui.mvi

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import org.alexcawl.forecaster.core.common.Consumer
import org.alexcawl.forecaster.core.common.Producer

abstract class BaseViewModel<S, A>(
    private val configuration: ViewModelConfiguration,
    initialState: S
) : Producer<S>, Consumer<A>, ViewModel() {
    private val scope = viewModelScope + configuration.intentDispatcher
    private val internalStateFlow = MutableStateFlow(value = initialState)
    private val internalActionFlow = MutableSharedFlow<A>(
        replay = 0,
        extraBufferCapacity = Int.MAX_VALUE
    )
    private val dispatchChannel = Channel<suspend StateContext<S>.() -> Unit>(capacity = Channel.UNLIMITED)
    private val stateContext: StateContext<S> = StateContext(reduce = internalStateFlow::update)

    init {
        scope.launch {
            for (intent in dispatchChannel) {
                viewModelScope.launch {
                    intent(stateContext)
                }
            }
        }
        scope.launch {
            internalActionFlow.collect(::handle)
        }
    }

    /**
     * State of the ViewModel.
     * */
    final override val state: StateFlow<S> = internalStateFlow.asStateFlow()

    /**
     * Consume action of the ViewModel.
     * */
    final override fun consume(action: A) {
        internalActionFlow.tryEmit(action)
    }

    /**
     * Handler for an action taken from a task queue.
     * Override this method in ViewModel implementation.
     * */
    protected abstract fun handle(action: A)

    /**
     * DSL method that allows to schedule the execution of a task.
     * */
    protected fun task(task: suspend StateContext<S>.() -> Unit) {
        if (dispatchChannel.trySend(task).isFailure) {
            configuration.intentScope.launch {
                dispatchChannel.send(task)
            }
        }
    }

    /**
     * Method that binds ViewModel lifecycle to Fragment/Activity lifecycle.
     * */
    internal fun observe(
        lifecycleOwner: LifecycleOwner,
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        state: ((S) -> Unit)? = null,
    ) {
        with(lifecycleOwner) {
            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(lifecycleState) {
                    state?.let {
                        launch {
                            internalStateFlow.collect(state)
                        }
                    }
                }
            }
        }
    }
}
