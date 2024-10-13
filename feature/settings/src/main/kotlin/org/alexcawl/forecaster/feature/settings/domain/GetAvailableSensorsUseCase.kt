package org.alexcawl.forecaster.feature.settings.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.alexcawl.forecaster.core.common.GetUseCase
import org.alexcawl.forecaster.core.persistence.repository.AvailableSensorsRepository
import javax.inject.Inject

class GetAvailableSensorsUseCase @Inject constructor(
    private val availableSensorsRepository: AvailableSensorsRepository
) : GetUseCase<List<SensorInfo>> {
    override operator fun invoke(): Flow<List<SensorInfo>> = flow {
        availableSensorsRepository.data.collect { sensors ->
            emit(
                sensors.map { sensor ->
                    SensorInfo(
                        name = sensor.name,
                        vendor = sensor.vendor,
                        type = sensor.stringType,
                        version = sensor.version
                    )
                }
            )
        }
    }
}
