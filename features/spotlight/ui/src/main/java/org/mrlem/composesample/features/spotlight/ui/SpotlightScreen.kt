package org.mrlem.composesample.features.spotlight.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

@Composable
internal fun SpotlightScreen(
    viewModel: SpotlightViewModel = hiltViewModel(),
    onSuggestionClick: (artistId: Long) -> Unit = {},
) {
    val state by viewModel.state.collectAsState()

    Spotlight(
        onSuggestionClick = { state.buttonArtistId?.let { onSuggestionClick(it) } },
    )
}

@Composable
private fun Spotlight(
    onSuggestionClick: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.size.medium),
        modifier = Modifier
            .fillMaxSize()
            .padding(Theme.size.medium),
    ) {
        Text(
            text = "Spotlight",
        )
        Text(
            text = "New songs by Muse have been added",
            modifier = Modifier
                .alpha(0.4f)
                .weight(1f),
        )
        Button(
            onClick = { onSuggestionClick() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Go to Muse")
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Spotlight()
        }
    }
}