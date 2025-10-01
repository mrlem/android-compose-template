package org.mrlem.composesample.features.library.data.datasources.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark")
data class BookmarkEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val image: String?,
)