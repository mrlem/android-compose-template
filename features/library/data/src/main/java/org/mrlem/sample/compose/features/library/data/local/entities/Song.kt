package org.mrlem.sample.compose.features.library.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey val id: Int,
    val title: String,
    val duration: Int,
    val artistId: Int,
)