package org.mrlem.sample.compose.feature.feature1.data.remote.api

import org.mrlem.sample.compose.feature.feature1.data.remote.dto.FilmDto
import retrofit2.http.GET

interface GhibliApi {

    @GET("/films")
    suspend fun listFilms(): List<FilmDto>

}