package org.alexcawl.forecaster.feature.settings.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.alexcawl.forecaster.core.ui.delegate.BaseDelegateAdapter
import org.alexcawl.forecaster.core.ui.mvi.BaseFragment
import org.alexcawl.forecaster.core.ui.utils.lazyViewModel
import org.alexcawl.forecaster.core.ui.utils.viewBinding
import org.alexcawl.forecaster.feature.settings.databinding.FragmentSettingsScreenBinding
import org.alexcawl.forecaster.feature.settings.di.FeatureSettingsComponentHolder
import org.alexcawl.forecaster.feature.settings.ui.adapter.SensorItemAdapter
import org.alexcawl.forecaster.feature.settings.ui.adapter.SettingsItem
import org.alexcawl.forecaster.feature.settings.ui.adapter.SettingsItemCallback
import org.alexcawl.forecaster.feature.settings.ui.adapter.ThemeItemAdapter
import org.alexcawl.forecaster.feature.settings.ui.adapter.TitleItemAdapter

class SettingsScreenFragment : BaseFragment<SettingsScreenState, SettingsScreenAction, FragmentSettingsScreenBinding>() {
    override val viewModel: SettingsScreenViewModel by lazyViewModel {
        FeatureSettingsComponentHolder.component.settingsScreenViewModelFactory.create()
    }

    override val binding: FragmentSettingsScreenBinding by viewBinding(FragmentSettingsScreenBinding::bind)

    private val listAdapter: BaseDelegateAdapter<SettingsItem> by lazy {
        BaseDelegateAdapter.Builder(SettingsItemCallback())
            .add(SensorItemAdapter())
            .add(ThemeItemAdapter { send(SettingsScreenAction.SetTheme(it)) })
            .add(TitleItemAdapter())
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val content = FragmentSettingsScreenBinding.inflate(inflater, container, false)
        return content.root
    }

    override fun render(state: SettingsScreenState) = when (state) {
        is SettingsScreenState.Loading -> {
            binding.progressBar.visibility = View.VISIBLE
            binding.toolbar.visibility = View.GONE
            binding.recyclerView.visibility = View.GONE
        }

        is SettingsScreenState.Base -> {
            with(binding.progressBar) {
                visibility = View.GONE
            }
            with(binding.toolbar) {
                visibility = View.VISIBLE
            }
            with(binding.backButton) {
                visibility = View.VISIBLE
                setOnClickListener {
                    send(SettingsScreenAction.NavigateBack)
                }
            }
            with(binding.recyclerView) {
                visibility = View.VISIBLE
                layoutManager = LinearLayoutManager(this.context)
                adapter = listAdapter
            }
            listAdapter.submitList(
                buildList {
                    add(SettingsItem.TitleItem("Sensors"))
                    addAll(state.availableSensors.map(SettingsItem::SensorItem))
                    add(SettingsItem.TitleItem("Theme"))
                    add(SettingsItem.ThemeItem(state.theme))
                }
            )
        }
    }
}
