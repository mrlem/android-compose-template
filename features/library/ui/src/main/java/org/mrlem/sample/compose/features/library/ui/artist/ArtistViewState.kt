package org.mrlem.sample.compose.features.library.ui.artist

import androidx.compose.runtime.Immutable
import org.mrlem.sample.compose.features.library.ui.ItemViewState

@Immutable
data class ArtistViewState(
    val name: String = "",
    val songs: List<ItemViewState<ArtistViewAction>> = emptyList(),
)