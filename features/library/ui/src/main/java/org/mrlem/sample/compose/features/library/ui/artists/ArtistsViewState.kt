package org.mrlem.sample.compose.features.library.ui.artists

import androidx.compose.runtime.Immutable
import org.mrlem.sample.compose.features.library.ui.ItemViewState

@Immutable
data class ArtistsViewState(
    val items: List<ItemViewState<ArtistsViewAction>> = emptyList(),
)