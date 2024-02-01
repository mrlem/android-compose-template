package org.mrlem.composesample.features.library.ui.artists

internal sealed interface ArtistsViewEffect {

    data class GoToArtist(val id: Long) : ArtistsViewEffect

    data object ShowError : ArtistsViewEffect

}