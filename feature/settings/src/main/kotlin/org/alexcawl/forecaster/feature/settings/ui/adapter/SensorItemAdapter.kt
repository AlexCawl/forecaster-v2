package org.alexcawl.forecaster.feature.settings.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.alexcawl.forecaster.core.ui.delegate.ItemDelegateAdapter
import org.alexcawl.forecaster.core.ui.delegate.ItemDelegateViewHolder
import org.alexcawl.forecaster.feature.settings.R
import org.alexcawl.forecaster.feature.settings.databinding.ItemSensorBinding
import java.util.Locale

class SensorItemAdapter : ItemDelegateAdapter<SettingsItem.SensorItem, SensorItemAdapter.SensorItemViewHolder>(
    modelClass = SettingsItem.SensorItem::class.java
) {
    class SensorItemViewHolder(
        binding: ItemSensorBinding
    ) : ItemDelegateViewHolder<SettingsItem.SensorItem, ItemSensorBinding>(
        binding = binding
    ) {
        override fun onBind(item: SettingsItem.SensorItem) {
            binding.textView.text = item.sensorInfo.name
            with(binding.cardView1Content) {
                textViewTitle.setText(R.string.type)
                textViewBody.text = item.sensorInfo.type
            }
            with(binding.cardView2Content) {
                textViewTitle.setText(R.string.vendor)
                textViewBody.text = item.sensorInfo.vendor
            }
            with(binding.cardView3Content) {
                textViewTitle.setText(R.string.version)
                textViewBody.text = String.format(
                    locale = Locale.getDefault(),
                    format = "%d",
                    item.sensorInfo.version
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSensorBinding.inflate(inflater, parent, false)
        return SensorItemViewHolder(binding)
    }

    override fun onBindViewHolder(item: SettingsItem.SensorItem, viewHolder: SensorItemViewHolder) {
        return viewHolder.onBind(item)
    }
}
