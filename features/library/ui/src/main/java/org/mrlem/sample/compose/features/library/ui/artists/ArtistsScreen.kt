package org.mrlem.sample.compose.features.library.ui.artists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.Theme
import org.mrlem.sample.compose.features.library.ui.Item
import org.mrlem.sample.compose.features.library.ui.ItemViewState

@Composable
fun ArtistsScreen(
    viewModel: ArtistsViewModel = hiltViewModel(),
    onArtistSelect: (id: Int) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effects
            .collect { effect ->
                when (effect) {
                    is ArtistsViewEffect.GoToArtist ->
                        onArtistSelect(effect.id)
                }
            }
    }

    LaunchedEffect(Unit) {
        viewModel.handleRedirections()
    }

    Artists(
        state = state,
        modifier = Modifier
            .fillMaxSize(),
        onAction = viewModel::onAction,
    )
}

@Composable
private fun Artists(
    state: ArtistsViewState,
    modifier: Modifier = Modifier,
    onAction: (ArtistsViewAction) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(state.items) {
            Item(
                viewState = it,
                onAction = onAction,
            )
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Artists(
                state = ArtistsViewState(
                    items = listOf(
                        ItemViewState(
                            label = "Georges Brassens",
                            description = "12 songs"
                        ),
                        ItemViewState(
                            label = "Jacques Brel",
                            description = "7 songs"
                        ),
                        ItemViewState(
                            label = "Joe Dassin",
                            description = "15 songs"
                        ),
                    ),
                ),
            )
        }
    }
}