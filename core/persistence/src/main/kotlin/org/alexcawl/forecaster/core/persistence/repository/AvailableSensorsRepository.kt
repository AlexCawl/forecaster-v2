package org.alexcawl.forecaster.core.persistence.repository

import android.hardware.Sensor
import android.hardware.SensorManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.alexcawl.forecaster.core.persistence.core.ReadOnlyRepository
import javax.inject.Inject

class AvailableSensorsRepository @Inject constructor(
    private val sensorManager: SensorManager
) : ReadOnlyRepository<List<Sensor>> {
    override val data: Flow<List<Sensor>> = flow {
        emit(sensorManager.getSensorList(Sensor.TYPE_ALL).toList())
    }
}
