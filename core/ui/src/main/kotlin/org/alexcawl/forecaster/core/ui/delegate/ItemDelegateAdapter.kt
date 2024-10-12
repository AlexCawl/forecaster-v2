package org.alexcawl.forecaster.core.ui.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ItemDelegateAdapter<I, in VH : RecyclerView.ViewHolder>(
    val modelClass: Class<out I>
) {
    abstract fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    abstract fun onBindViewHolder(
        item: I,
        viewHolder: VH
    )

    open fun onViewRecycled(viewHolder: VH) = Unit

    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit

    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}
