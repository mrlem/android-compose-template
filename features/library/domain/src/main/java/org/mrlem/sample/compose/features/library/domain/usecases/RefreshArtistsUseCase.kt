package org.mrlem.sample.compose.features.library.domain.usecases

import org.mrlem.sample.compose.features.library.domain.repositories.SongRepository
import javax.inject.Inject

class RefreshArtistsUseCase @Inject constructor(
    private val repository: SongRepository,
) {

    suspend operator fun invoke() =
        repository.download()

}