package org.mrlem.sample.compose.feature.feature1.domain.repository

import kotlinx.coroutines.flow.Flow
import org.mrlem.sample.compose.arch.domain.Loadable
import org.mrlem.sample.compose.feature.feature1.domain.model.Film

interface GhibliRepository {

    // data
    fun getFilm(id: String): Flow<Loadable<Film>>
    fun listFilms(): Flow<Loadable<List<Film>>>

    // actions
    suspend fun refresh()
    suspend fun favorite(id: String)
    suspend fun unfavorite(id: String)

}