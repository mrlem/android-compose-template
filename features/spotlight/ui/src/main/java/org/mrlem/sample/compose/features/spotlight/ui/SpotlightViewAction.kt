package org.mrlem.sample.compose.features.spotlight.ui

sealed interface SpotlightViewAction {

    data object ButtonClick : SpotlightViewAction

}