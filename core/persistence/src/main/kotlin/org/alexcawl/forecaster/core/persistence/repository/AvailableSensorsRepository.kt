package org.alexcawl.forecaster.core.persistence.repository

import android.hardware.Sensor
import android.hardware.SensorManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.alexcawl.forecaster.core.persistence.core.ReadOnlyRepository
import org.alexcawl.forecaster.core.persistence.entity.SensorInfo

class AvailableSensorsRepository(
    private val sensorManager: SensorManager
) : ReadOnlyRepository<List<SensorInfo>> {
    override val data: Flow<List<SensorInfo>> = flow {
        emit(
            sensorManager.getSensorList(Sensor.TYPE_ALL).map {
                SensorInfo(
                    name = it.name,
                    vendor = it.vendor,
                    version = it.version
                )
            }
        )
    }
}
