package org.mrlem.sample.compose.feature.ghibli.data.remote

import retrofit2.http.GET

interface GhibliApi {

    @GET("films")
    suspend fun listFilms(): FilmsDataDto

}