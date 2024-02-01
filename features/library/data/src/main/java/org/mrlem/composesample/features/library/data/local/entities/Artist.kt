package org.mrlem.composesample.features.library.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Artist(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
)