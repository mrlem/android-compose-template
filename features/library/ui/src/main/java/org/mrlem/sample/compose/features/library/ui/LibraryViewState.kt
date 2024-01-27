package org.mrlem.sample.compose.features.library.ui

import androidx.compose.runtime.Immutable

data class LibraryViewState(
    val items: List<ItemViewState> = emptyList(),
)

@Immutable
data class ItemViewState(
    val label: String,
    val description: String,
)