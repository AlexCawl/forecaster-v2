package org.alexcawl.forecaster.feature.settings.domain

data class SensorInfo(
    val name: String,
    val vendor: String,
    val type: String,
    val version: Int,
)
