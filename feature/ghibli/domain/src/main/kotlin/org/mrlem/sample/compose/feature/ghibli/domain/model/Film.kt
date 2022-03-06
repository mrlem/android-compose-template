package org.mrlem.sample.compose.feature.ghibli.domain.model

data class Film(
    val id: String,
    val title: String,
    val originalTitle: String,
    val originalTitleRomanized: String,
    val image: String,
    val description: String,
)