package org.mrlem.sample.compose.features.library.ui.artists

import androidx.compose.runtime.Immutable

data class ArtistsViewState(
    val items: List<ItemViewState> = emptyList(),
)

@Immutable
data class ItemViewState(
    val label: String,
    val description: String,
)