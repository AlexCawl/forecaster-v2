package org.alexcawl.forecaster.core.ui.delegate

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BaseDelegateAdapter<I : Any> private constructor(
    private val adapters: List<ItemDelegateAdapter<I, RecyclerView.ViewHolder>>,
    callback: DiffUtil.ItemCallback<I>
) : ListAdapter<I, RecyclerView.ViewHolder>(callback) {
    class Builder<I : Any>(
        private val callback: DiffUtil.ItemCallback<I>
    ) {
        private val adapters: MutableList<ItemDelegateAdapter<I, RecyclerView.ViewHolder>> =
            mutableListOf()

        @Suppress("UNCHECKED_CAST")
        fun add(adapter: ItemDelegateAdapter<*, *>): Builder<I> {
            adapters.add(adapter as ItemDelegateAdapter<I, RecyclerView.ViewHolder>)
            return this
        }

        fun build(): BaseDelegateAdapter<I> {
            require(adapters.isNotEmpty()) { "Register at least one adapter!" }
            return BaseDelegateAdapter(adapters, callback)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder = adapters[viewType].onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, position, mutableListOf())
    }

    override fun getItemViewType(position: Int): Int {
        for (i in adapters.indices) {
            if (adapters[i].modelClass == getItem(position).javaClass) {
                return i
            }
        }
        error("Can not get viewType for position $position!")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val delegateAdapter = adapters[getItemViewType(position)]
        delegateAdapter.onBindViewHolder(getItem(position), holder)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        adapters[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }
}
