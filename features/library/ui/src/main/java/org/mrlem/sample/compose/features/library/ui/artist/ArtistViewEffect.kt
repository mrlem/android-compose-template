package org.mrlem.sample.compose.features.library.ui.artist

sealed interface ArtistViewEffect {

    data object GoBack : ArtistViewEffect

}