package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FilmDetailScreen(
    viewModel: FilmDetailViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
) {
    FilmDetailLayout(
        state = viewModel.state,
        onFavoriteClick = { viewModel.toggleFavorite() },
    )
}