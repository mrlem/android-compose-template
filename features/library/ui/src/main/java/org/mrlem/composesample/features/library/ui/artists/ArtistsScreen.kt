package org.mrlem.composesample.features.library.ui.artists

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme
import org.mrlem.composesample.features.library.ui.Item
import org.mrlem.composesample.features.library.ui.ItemViewState

@Composable
internal fun ArtistsScreen(
    snackbarHostState: SnackbarHostState,
    viewModel: ArtistsViewModel = hiltViewModel(),
    onArtistSelect: (id: Long) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effects
            .collect { effect ->
                when (effect) {
                    is ArtistsViewEffect.GoToArtist ->
                        onArtistSelect(effect.id)
                    is ArtistsViewEffect.ShowError ->
                        snackbarHostState.showSnackbar("Failed to retrieve data")
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
    Box(
        modifier = modifier,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(state.items) {
                Item(
                    viewState = it,
                    onAction = onAction,
                )
            }
        }

        FloatingActionButton(
            onClick = { onAction(ArtistsViewAction.RefreshClick) },
            shape = CircleShape,
            modifier = Modifier
                .padding(Theme.size.medium)
                .align(Alignment.TopEnd),
        ) {
            Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Download new songs")
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