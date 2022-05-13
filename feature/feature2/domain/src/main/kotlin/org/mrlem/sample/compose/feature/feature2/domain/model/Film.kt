package org.mrlem.sample.compose.feature.feature2.domain.model

data class Film(
    val id: String,
    val title: String,
    val originalTitle: String,
    val originalTitleRomanised: String,
    val coverImage: String,
    val bannerImage: String,
    val description: String,
    val director: String,
    val releaseDate: String,
    val isFavorite: Boolean = false,
)