package org.mrlem.composesample.features.library.data.repositories

import org.mrlem.composesample.features.library.data.local.entities.Artist
import org.mrlem.composesample.features.library.data.local.entities.Song

object SampleData {

    val artists = listOf(
        Artist(
            id = 0,
            name = "Cocoon",
        ),
        Artist(
            id = 1,
            name = "Elvis Presley",
        ),
        Artist(
            id = 2,
            name = "Muse",
        ),
    )

    val songs = listOf(
        Song(
            id = 0,
            title = "Let me!",
            duration = 127,
            artistId = 0,
        ),
        Song(
            id = 1,
            title = "The final countdown",
            duration = 148,
            artistId = 0,
        ),
        Song(
            id = 2,
            title = "Fireworks",
            duration = 112,
            artistId = 1,
        ),
        Song(
            id = 3,
            title = "Words are words",
            duration = 136,
            artistId = 2,
        ),
    )

}