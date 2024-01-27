package org.mrlem.sample.compose.features.library.domain.repositories

import org.mrlem.sample.compose.features.library.domain.model.Artist

interface SongRepository {

    suspend fun getArtists(): List<Artist>

    suspend fun getArtist(id: Int): Artist?

}