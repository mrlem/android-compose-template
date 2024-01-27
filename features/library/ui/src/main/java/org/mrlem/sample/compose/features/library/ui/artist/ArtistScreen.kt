package org.mrlem.sample.compose.features.library.ui.artist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.Theme

@Composable
internal fun ArtistScreen(
    viewModel: ArtistViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Artist(
        state = state,
    )
}

@Composable
private fun Artist(state: ArtistViewState) {
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
            // TODO
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Artist(
                state = ArtistViewState(
                    name = "Muse",
                ),
            )
        }
    }
}