package org.mrlem.sample.compose.features.library.ui.artist

sealed interface ArtistViewAction {

    data object Back : ArtistViewAction

}