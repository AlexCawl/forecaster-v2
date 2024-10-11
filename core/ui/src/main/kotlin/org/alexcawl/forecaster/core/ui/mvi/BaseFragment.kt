package org.alexcawl.forecaster.core.ui.mvi

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<S, A, VB : ViewBinding> : UiComponent<S, A>, Fragment {
    protected abstract val viewModel: BaseViewModel<S, A>
    protected abstract val binding: VB

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    final override fun send(action: A) = viewModel.consume(action)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observe(
            lifecycleOwner = viewLifecycleOwner,
            state = ::render
        )
    }
}
