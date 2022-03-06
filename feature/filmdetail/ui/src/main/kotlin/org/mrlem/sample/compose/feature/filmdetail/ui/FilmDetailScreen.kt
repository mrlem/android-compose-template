package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FilmDetailScreen(
    id: String,
    navigateToHome: () -> Unit,
) {
    val viewModel: FilmDetailViewModel = hiltViewModel<FilmDetailViewModel>()
        .apply { filmId = id }

    FilmDetailLayout(
        state = viewModel.state,
        onFavoriteClick = { viewModel.toggleFavorite() },
        onBackClick = { navigateToHome() },
    )
}