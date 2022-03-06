package org.mrlem.sample.compose.feature.favorites.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.mrlem.sample.compose.feature.favorites.data.local.Favorite
import org.mrlem.sample.compose.feature.favorites.data.local.FavoriteDao
import org.mrlem.sample.compose.feature.favorites.domain.repository.FavoriteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepositoryImpl @Inject constructor(
    private val dao: FavoriteDao,
) : FavoriteRepository {

    override suspend fun toggle(filmId: String) {
        val favorite = dao.getByFilmId(filmId)
            .first()
        if (favorite != null) {
            dao.delete(favorite)
        } else {
            dao.insert(Favorite(filmId = filmId))
        }
    }

    override fun isFavorite(filmId: String): Flow<Boolean> =
        dao.getByFilmId(filmId)
            .map { it != null }

    override fun list(): Flow<List<String>> =
        dao.list()
            .map { favorites -> favorites.map { it.filmId } }

}