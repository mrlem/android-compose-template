package org.mrlem.composesample.features.library.ui.artists

import androidx.compose.runtime.Immutable
import org.mrlem.composesample.features.library.ui.ItemViewState

@Immutable
internal data class ArtistsViewState(
    val items: List<ItemViewState<ArtistsViewAction>> = emptyList(),
)