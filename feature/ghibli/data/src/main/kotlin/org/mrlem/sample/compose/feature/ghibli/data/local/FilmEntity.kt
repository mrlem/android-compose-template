package org.mrlem.sample.compose.feature.ghibli.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

@Entity(tableName = "film")
data class FilmEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    var originalTitle: String,
    val originalTitleRomanised: String,
    val image: String,
    val movieBanner: String,
    val description: String,
    val director: String,
    val releaseDate: String,
    val isFavorite: Boolean,
) {

    fun toModel() = Film(
        id = id,
        title = title,
        originalTitle = originalTitle,
        originalTitleRomanised = originalTitleRomanised,
        coverImage = image,
        bannerImage = movieBanner,
        description = description,
        director = director,
        releaseDate = releaseDate,
        isFavorite = isFavorite,
    )

}

fun Film.toEntity(): FilmEntity = FilmEntity(
    id = id,
    title = title,
    originalTitle = originalTitle,
    originalTitleRomanised = originalTitleRomanised,
    image = coverImage,
    movieBanner = bannerImage,
    description = description,
    director = director,
    releaseDate = releaseDate,
    isFavorite = isFavorite,
)