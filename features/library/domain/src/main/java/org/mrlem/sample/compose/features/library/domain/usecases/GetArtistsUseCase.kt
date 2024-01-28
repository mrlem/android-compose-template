package org.mrlem.sample.compose.features.library.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.domain.repositories.SongRepository
import javax.inject.Inject

class GetArtistsUseCase @Inject constructor(
    private val repository: SongRepository,
) {

    operator fun invoke(): Flow<List<Artist>> =
        repository.getArtists()

}