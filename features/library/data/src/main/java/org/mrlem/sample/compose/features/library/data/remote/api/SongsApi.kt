package org.mrlem.sample.compose.features.library.data.remote.api

import org.mrlem.sample.compose.features.library.data.remote.dtos.Artist
import retrofit2.http.GET

interface SongsApi {

    @GET("songs/v1/")
    suspend fun list(): List<Artist>

}