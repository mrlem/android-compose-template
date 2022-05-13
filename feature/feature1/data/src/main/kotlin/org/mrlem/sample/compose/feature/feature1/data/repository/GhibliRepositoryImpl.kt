package org.mrlem.sample.compose.feature.feature1.data.repository

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import org.mrlem.sample.compose.arch.domain.Loadable
import org.mrlem.sample.compose.arch.domain.Loadable.Loading
import org.mrlem.sample.compose.arch.domain.Loadable.Success
import org.mrlem.sample.compose.feature.feature1.data.local.dao.FilmDao
import org.mrlem.sample.compose.feature.feature1.data.local.entity.toEntity
import org.mrlem.sample.compose.feature.feature1.data.remote.api.GhibliApi
import org.mrlem.sample.compose.feature.feature1.domain.model.Film
import org.mrlem.sample.compose.feature.feature1.domain.repository.GhibliRepository
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

    @OptIn(FlowPreview::class)
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
        val films = api.listFilms()
            .map { it.toModel() }
            .map { it.toEntity() }

        dao.insertAll(films)
    }

    private fun listFilmsInCache() =
        dao.list()
            .map { films ->
                needsRefresh = false
                Success(films.map { it.toModel() })
            }

}