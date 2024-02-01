package org.mrlem.composesample.features.library.ui.artist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

@Composable
internal fun ArtistScreen(
    viewModel: ArtistViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    ArtistAndSongs(
        state = state,
    )
}

@Composable
private fun ArtistAndSongs(state: ArtistViewState) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(
            text = state.name,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Theme.size.larger,
                    horizontal = Theme.size.medium,
                ),
        )
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .fillMaxSize()
                .weight(1f),
        ) {
            items(state.songs) { song ->
                Song(song)
            }
        }
    }
}

@Composable
private fun Song(song: ArtistViewState.Song) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Theme.size.medium),
    ) {
        Text(
            text = song.name,
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = song.duration,
        )
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            ArtistAndSongs(
                state = ArtistViewState(
                    name = "Muse",
                ),
            )
        }
    }
}