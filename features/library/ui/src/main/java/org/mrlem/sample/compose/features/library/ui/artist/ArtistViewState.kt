package org.mrlem.sample.compose.features.library.ui.artist

import androidx.compose.runtime.Immutable

@Immutable
data class ArtistViewState(
    val name: String = "",
)