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
        onClick = { navigateToFilm("58611129-2dbc-4a81-a72f-77ddfc1b1b49") },
    )
}