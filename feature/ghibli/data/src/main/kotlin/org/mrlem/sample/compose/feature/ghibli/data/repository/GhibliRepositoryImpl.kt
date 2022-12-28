package org.mrlem.sample.compose.feature.ghibli.data.repository

import kotlinx.coroutines.flow.*
import org.mrlem.sample.compose.arch.domain.Loadable
import org.mrlem.sample.compose.arch.domain.Loadable.Loading
import org.mrlem.sample.compose.arch.domain.Loadable.Success
import org.mrlem.sample.compose.feature.ghibli.data.local.FilmDao
import org.mrlem.sample.compose.feature.ghibli.data.local.toEntity
import org.mrlem.sample.compose.feature.ghibli.data.remote.GhibliApi
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GhibliRepositoryImpl @Inject constructor(
    private val api: GhibliApi,
    private val dao: FilmDao,
) : GhibliRepository {

    private var needsRefresh = true

    override fun getFilm(id: String) = dao.getById(id)
        .map { Success(it.toModel()) }

    override fun listFilms() = flow<Loadable<List<Film>>> {
        if (needsRefresh) {
            updateFilms()
        }
        emit(Loading())
    }
        .onCompletion {
            emitAll(listFilmsInCache())
        }

    override suspend fun refresh() {
        updateFilms()
    }

    override suspend fun favorite(id: String) = dao.favorite(id)

    override suspend fun unfavorite(id: String) = dao.unfavorite(id)

    private suspend fun updateFilms() {
        try {
            val films = api.listFilms()
                .map { it.toModel() }
                .map { it.toEntity() }

            dao.insertAll(films)
        } catch (e: Exception) {
            Timber.e("failed to retrieve movies: ${e.message}")
        }
    }

    private fun listFilmsInCache() =
        dao.list()
            .map { films ->
                needsRefresh = false
                Success(films.map { it.toModel() })
            }

}