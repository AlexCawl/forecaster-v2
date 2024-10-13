package org.alexcawl.forecaster.feature.settings.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.forecaster.core.persistence.entity.Theme
import org.alexcawl.forecaster.core.ui.delegate.ItemDelegateAdapter
import org.alexcawl.forecaster.core.ui.delegate.ItemDelegateViewHolder
import org.alexcawl.forecaster.feature.settings.R
import org.alexcawl.forecaster.feature.settings.databinding.ItemThemeBinding

class ThemeItemAdapter(
    private val onThemeSelected: (Theme) -> Unit
) : ItemDelegateAdapter<SettingsItem.ThemeItem, ThemeItemAdapter.ThemeItemViewHolder>(
    modelClass = SettingsItem.ThemeItem::class.java
) {
    class ThemeItemViewHolder(
        private val onThemeSelected: (Theme) -> Unit,
        binding: ItemThemeBinding
    ) : ItemDelegateViewHolder<SettingsItem.ThemeItem, ItemThemeBinding>(
        binding = binding
    ) {
        override fun onBind(item: SettingsItem.ThemeItem) {
            with(binding.dayButton) {
                setIconResource(R.drawable.round_sun_24)
                setText(R.string.day)
                setOnClickListener {
                    onThemeSelected(Theme.Day)
                }
                isChecked = (item.theme == Theme.Day)
            }
            with(binding.systemButton) {
                setIconResource(R.drawable.round_phone_android_24)
                setText(R.string.system)
                setOnClickListener {
                    onThemeSelected(Theme.System)
                }
                isChecked = (item.theme == Theme.System)
            }
            with(binding.nightButton) {
                setIconResource(R.drawable.round_mode_night_24)
                setText(R.string.night)
                setOnClickListener {
                    onThemeSelected(Theme.Night)
                }
                isChecked = (item.theme == Theme.Night)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemThemeBinding.inflate(inflater, parent, false)
        return ThemeItemViewHolder(onThemeSelected, binding)
    }

    override fun onBindViewHolder(
        item: SettingsItem.ThemeItem,
        viewHolder: ThemeItemViewHolder
    ) {
        return viewHolder.onBind(item)
    }
}
