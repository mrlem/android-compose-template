package org.mrlem.sample.compose.features.library.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Artist(
    @PrimaryKey val id: Int,
    @ColumnInfo("name") val name: String,
)