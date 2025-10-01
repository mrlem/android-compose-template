package org.mrlem.composesample.features.library.ui.list

internal data class ListItemViewState<Action>(
    val label: String,
    val onClickAction: Action? = null,
)