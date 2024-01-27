package org.mrlem.sample.compose.features.library.ui.artists

internal sealed interface ArtistsViewEffect {

    data class GoToArtist(val id: Int) : ArtistsViewEffect

}