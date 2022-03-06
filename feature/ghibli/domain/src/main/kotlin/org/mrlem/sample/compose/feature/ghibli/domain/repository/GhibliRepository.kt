package org.mrlem.sample.compose.feature.ghibli.domain.repository

import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

interface GhibliRepository {

    suspend fun getFilm(id: String): Film
    suspend fun listFilms(): List<Film>

}