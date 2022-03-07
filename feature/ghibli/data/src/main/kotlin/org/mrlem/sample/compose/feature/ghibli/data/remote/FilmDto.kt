package org.mrlem.sample.compose.feature.ghibli.data.remote

import com.squareup.moshi.Json
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

data class FilmDto(
    val id: String,
    val title: String,
    @field:Json(name="original_title")
    var originalTitle: String,
    @field:Json(name="original_title_romanised")
    val originalTitleRomanised: String,
    val image: String,
    @field:Json(name="movie_banner")
    val movieBanner: String,
    val description: String,
    val director: String,
    val producer: String,
    @field:Json(name="release_date")
    val releaseDate: String,
) {

    fun toModel() = Film(
        id = id,
        title = title,
        originalTitle = originalTitle,
        originalTitleRomanised = originalTitleRomanised,
        image = movieBanner,
        description = description,
        director = director,
        releaseDate = releaseDate,
    )
}