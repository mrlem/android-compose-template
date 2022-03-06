package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FilmDetailScreen(viewModel: FilmDetailViewModel = viewModel()) {
    FilmDetailLayout(
        state = viewModel.state,
        onFavoriteClick = { viewModel.toggleFavorite() },
    )
}