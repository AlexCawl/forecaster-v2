package org.alexcawl.forecaster.feature.settings.domain

import kotlinx.coroutines.flow.Flow
import org.alexcawl.forecaster.core.common.GetUseCase
import org.alexcawl.forecaster.core.persistence.entity.Theme
import org.alexcawl.forecaster.core.persistence.repository.ThemeRepository
import javax.inject.Inject

class GetThemeUseCase @Inject constructor(
    private val themeRepository: ThemeRepository
) : GetUseCase<Theme> {
    override fun invoke(): Flow<Theme> = themeRepository.data
}
