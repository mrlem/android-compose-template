package org.mrlem.sample.compose.feature.filmslist.ui

import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

internal data class FilmsListState(
    val films: List<Film> = emptyList(),
)