package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.feature.filmdetail.ui.component.Layout

@Composable
fun FilmDetailScreen(
    navigateToHome: () -> Unit = {},
) {
    val viewModel: FilmDetailViewModel = hiltViewModel()

    Layout(
        state = viewModel.state,
        onFavoriteClick = { viewModel.toggleFavorite() },
        onBackClick = { navigateToHome() },
    )
}