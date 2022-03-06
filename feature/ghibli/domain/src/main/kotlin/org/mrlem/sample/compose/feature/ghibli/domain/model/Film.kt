package org.mrlem.sample.compose.feature.ghibli.domain.model

import java.net.URL

data class Film(
    val id: String,
    val title: String,
    val originalTitle: String,
    val originalTitleRomanized: String,
    val image: URL,
    val description: String,
)