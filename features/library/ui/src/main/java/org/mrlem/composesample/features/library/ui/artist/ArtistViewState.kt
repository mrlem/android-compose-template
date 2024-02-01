package org.mrlem.composesample.features.library.ui.artist

import androidx.compose.runtime.Immutable

@Immutable
internal data class ArtistViewState(
    val name: String = "",
    val songs: List<Song> = emptyList(),
) {

    data class Song(
        val name: String,
        val duration: String,
    )

}