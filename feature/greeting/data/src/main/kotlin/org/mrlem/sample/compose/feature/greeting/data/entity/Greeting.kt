package org.mrlem.sample.compose.feature.greeting.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Greeting(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
) {

    fun toModel() = org.mrlem.sample.compose.feature.greeting.domain.model.Greeting(
        id = id,
        text = text,
    )

}