package org.mrlem.sample.compose.features.library.ui

data class ItemViewState<Action>(
    val label: String,
    val description: String,
    val onClickAction: Action? = null,
)