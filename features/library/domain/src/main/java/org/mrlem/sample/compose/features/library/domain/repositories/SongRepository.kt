package org.mrlem.sample.compose.features.library.domain.repositories

import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.features.library.domain.model.Artist

interface SongRepository {

    fun getArtists(): Flow<List<Artist>>

    suspend fun getArtist(id: Long): Artist?

    suspend fun findArtistIdByName(name: String): Long?

    suspend fun download(): Int

}