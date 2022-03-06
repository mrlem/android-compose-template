package org.mrlem.sample.compose.feature.ghibli.data.repository

import org.mrlem.sample.compose.feature.ghibli.data.remote.GhibliApi
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import javax.inject.Inject

class GhibliRepositoryImpl @Inject constructor(
    private val api: GhibliApi,
) : GhibliRepository {

    override suspend fun getFilm(id: String): Film =
        api.getFilm(id)
            .toModel()

    override suspend fun listFilms(): List<Film> =
        api.listFilms()
            .map { it.toModel() }

}