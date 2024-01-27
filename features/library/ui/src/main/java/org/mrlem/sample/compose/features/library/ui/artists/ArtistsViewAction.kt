package org.mrlem.sample.compose.features.library.ui.artists

internal sealed interface ArtistsViewAction {

    data class SelectArtist(val artistId: Int) : ArtistsViewAction

}