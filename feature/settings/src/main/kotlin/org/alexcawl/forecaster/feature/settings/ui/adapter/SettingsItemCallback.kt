package org.alexcawl.forecaster.feature.settings.ui.adapter

import androidx.recyclerview.widget.DiffUtil

class SettingsItemCallback : DiffUtil.ItemCallback<SettingsItem>() {
    override fun areItemsTheSame(oldItem: SettingsItem, newItem: SettingsItem): Boolean {
        return oldItem::class == newItem::class && oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: SettingsItem, newItem: SettingsItem): Boolean {
        return oldItem == newItem
    }
}
