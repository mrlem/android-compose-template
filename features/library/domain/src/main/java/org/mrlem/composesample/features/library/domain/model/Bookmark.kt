package org.mrlem.composesample.features.library.domain.model

data class Bookmark(
    val id: Long,
    val name: String,
    val description: String?,
    val image: String?,
)