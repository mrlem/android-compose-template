package org.mrlem.sample.compose.feature.feature2.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.feature.feature2.ui.component.Layout

@Composable
fun FilmsListScreen(
    navigateToFilm: (String) -> Unit,
) {
    val viewModel: FilmsListViewModel = hiltViewModel()

    Layout(
        state = viewModel.state,
        onClick = { id -> navigateToFilm(id) },
        onRefresh = { viewModel.refresh() },
    )
}