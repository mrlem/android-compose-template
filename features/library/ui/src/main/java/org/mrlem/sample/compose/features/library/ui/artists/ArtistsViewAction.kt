package org.mrlem.sample.compose.features.library.ui.artists

sealed interface ArtistsViewAction {

    data class SelectArtist(val artistId: Int) : ArtistsViewAction

}