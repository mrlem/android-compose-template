package org.mrlem.sample.compose.feature.favorites.domain.repository

import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun toggle(filmId: String)
    fun isFavorite(filmId: String): Flow<Boolean>
    fun list(): Flow<List<String>>

}