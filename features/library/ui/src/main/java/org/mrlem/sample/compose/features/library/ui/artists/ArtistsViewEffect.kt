package org.mrlem.sample.compose.features.library.ui.artists

sealed interface ArtistsViewEffect {

    data class GoToArtist(val id: Int) : ArtistsViewEffect

}