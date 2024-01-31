package org.mrlem.sample.compose.features.library.domain.repositories

import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.features.library.domain.model.Artist
import org.mrlem.sample.compose.features.library.domain.model.Song

interface SongRepository {

    fun getArtists(): Flow<List<Pair<Artist, Int>>>

    suspend fun getArtist(id: Long): Pair<Artist, List<Song>>?

    suspend fun findArtistIdByName(name: String): Long?

    suspend fun download(): Int

}