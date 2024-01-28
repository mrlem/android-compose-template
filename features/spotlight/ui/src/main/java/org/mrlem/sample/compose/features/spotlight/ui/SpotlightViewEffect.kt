package org.mrlem.sample.compose.features.spotlight.ui

sealed interface SpotlightViewEffect {

    data class GoToArtist(val id: Long): SpotlightViewEffect

}