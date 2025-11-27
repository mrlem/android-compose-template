package org.mrlem.composesample.features.library.data.datasources.remote

import org.mrlem.composesample.features.library.data.datasources.remote.dtos.ResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaDataSource {

    @GET("api.php?action=query&format=json&prop=pageimages|pageprops&pithumbsize=250")
    suspend fun findByName(@Query("titles") name: String): ResultDto

    @GET("api.php?action=query&format=json&list=random&rnnamespace=0")
    suspend fun findRandom(@Query("rnlimit") limit: Int = 1): ResultDto
}