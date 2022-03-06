package org.mrlem.sample.compose.feature.ghibli.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface GhibliApi {

    @GET("/films/{id}")
    suspend fun getFilm(@Path("id") id: String): FilmDto

    @GET("/films")
    suspend fun listFilms(): List<FilmDto>

}