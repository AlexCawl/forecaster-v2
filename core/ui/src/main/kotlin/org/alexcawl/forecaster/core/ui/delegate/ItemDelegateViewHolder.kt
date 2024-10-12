package org.alexcawl.forecaster.core.ui.delegate

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ItemDelegateViewHolder<I, VB : ViewBinding>(
    protected val binding: VB
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun onBind(item: I)
}
