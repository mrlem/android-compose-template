package org.mrlem.composesample.features.library.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val duration: Int,
    val artistId: Long,
)