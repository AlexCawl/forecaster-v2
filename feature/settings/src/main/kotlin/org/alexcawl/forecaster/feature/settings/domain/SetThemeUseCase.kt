package org.alexcawl.forecaster.feature.settings.domain

import org.alexcawl.forecaster.core.common.SetUseCase
import org.alexcawl.forecaster.core.persistence.entity.Theme
import org.alexcawl.forecaster.core.persistence.repository.ThemeRepository
import javax.inject.Inject

class SetThemeUseCase @Inject constructor(
    private val themeRepository: ThemeRepository
): SetUseCase<Theme> {
    override suspend fun invoke(value: Theme) = themeRepository.set(value)
}
