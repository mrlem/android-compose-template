package org.mrlem.sample.compose.features.library.domain.usecases

import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.domain.repositories.SongRepository
import javax.inject.Inject

class GetArtistUseCase @Inject constructor(
    private val repository: SongRepository,
) {

    suspend operator fun invoke(id: Int): Artist? =
        repository.getArtist(id)

}