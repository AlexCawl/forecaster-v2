package org.alexcawl.forecaster.feature.settings.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.forecaster.core.ui.delegate.ItemDelegateAdapter
import org.alexcawl.forecaster.core.ui.delegate.ItemDelegateViewHolder
import org.alexcawl.forecaster.feature.settings.databinding.ItemTitleBinding

class TitleItemAdapter : ItemDelegateAdapter<SettingsItem.TitleItem, TitleItemAdapter.TitleItemViewHolder>(
    modelClass = SettingsItem.TitleItem::class.java
) {
    class TitleItemViewHolder(binding: ItemTitleBinding) : ItemDelegateViewHolder<SettingsItem.TitleItem, ItemTitleBinding>(
        binding = binding
    ) {
        override fun onBind(item: SettingsItem.TitleItem) {
            binding.textView.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTitleBinding.inflate(inflater, parent, false)
        return TitleItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: SettingsItem.TitleItem,
        viewHolder: TitleItemViewHolder
    ) {
        return viewHolder.onBind(item)
    }
}