package org.mrlem.sample.compose.feature.filmslist.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FilmsListScreen(
    viewModel: FilmsListViewModel = hiltViewModel(),
    navigateToFilm: (String) -> Unit,
) {
    FilmsListLayout(
        state = viewModel.state,
        onClick = { id -> navigateToFilm(id) },
    )
}