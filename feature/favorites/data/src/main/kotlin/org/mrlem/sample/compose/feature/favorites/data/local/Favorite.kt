package org.mrlem.sample.compose.feature.favorites.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val filmId: String,
)