package org.mrlem.composesample.features.library.ui.list

import androidx.compose.runtime.Immutable

@Immutable
internal data class ListViewState(
    val filter: String = "",
    val items: List<ListItemViewState<ListViewAction>> = emptyList(),
)