package org.mrlem.sample.compose.features.library.ui.artists

internal sealed interface ArtistsViewAction {

    data class ArtistClick(val artistId: Long) : ArtistsViewAction

    data object RefreshClick : ArtistsViewAction

}