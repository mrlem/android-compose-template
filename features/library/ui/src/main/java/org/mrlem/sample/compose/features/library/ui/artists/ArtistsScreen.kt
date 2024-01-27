package org.mrlem.sample.compose.features.library.ui.artists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.ComposeSampleTheme
import org.mrlem.sample.compose.core.ui.theme.Theme

@Composable
fun ArtistsScreen(
    viewModel: ArtistsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    Artists(
        state = state,
        modifier = Modifier
            .fillMaxSize(),
    )
}

@Composable
private fun Artists(
    state: ArtistsViewState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(state.items) {
            Item(it)
        }
    }
}

@Composable
private fun Item(viewState: ItemViewState) {
    Column(
        modifier = Modifier
            .clickable { /* TODO*/ }
            .fillMaxWidth()
            .padding(Theme.size.small),
    ){
        Text(
            text = viewState.label,
        )
        Text(
            text = viewState.description,
            modifier = Modifier
                .alpha(0.4f),
        )
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    ComposeSampleTheme {
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