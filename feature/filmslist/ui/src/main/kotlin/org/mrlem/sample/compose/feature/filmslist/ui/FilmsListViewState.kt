package org.mrlem.sample.compose.feature.filmslist.ui

import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

internal data class FilmsListViewState(
    val films: List<Film> = emptyList(),
    val isRefreshing: Boolean = false,
)