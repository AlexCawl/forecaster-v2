package org.alexcawl.forecaster.core.ui.mvi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<S, A, VB : ViewBinding> : UiComponent<S, A>, AppCompatActivity {
    protected abstract val viewModel: BaseViewModel<S, A>
    protected abstract val binding: VB

    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    final override fun send(action: A) = viewModel.consume(action)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.observe(
            lifecycleOwner = this,
            state = ::render
        )
    }
}