package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FilmDetailScreen(
    navigateToHome: () -> Unit,
) {
    val viewModel: FilmDetailViewModel = hiltViewModel()

    FilmDetailLayout(
        state = viewModel.state,
        onFavoriteClick = { viewModel.toggleFavorite() },
        onBackClick = { navigateToHome() },
    )
}