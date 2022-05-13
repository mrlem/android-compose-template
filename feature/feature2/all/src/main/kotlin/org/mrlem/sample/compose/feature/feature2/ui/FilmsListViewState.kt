package org.mrlem.sample.compose.feature.feature2.ui

import org.mrlem.sample.compose.feature.feature2.domain.model.Film

internal data class FilmsListViewState(
    val films: List<Film> = emptyList(),
    val isRefreshing: Boolean = false,
)