package org.mrlem.sample.compose.features.library.ui.artist

import androidx.compose.runtime.Immutable

@Immutable
internal data class ArtistViewState(
    val name: String = "",
)