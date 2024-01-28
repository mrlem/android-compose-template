package org.mrlem.sample.compose.features.spotlight.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.core.feature.ui.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.Theme

@Composable
internal fun SpotlightScreen(
    viewModel: SpotlightViewModel = hiltViewModel(),
    onSuggestionClick: (artistId: Long) -> Unit = {},
) {
    LaunchedEffect(Unit) {
        viewModel.effects
            .collect { effect ->
                when (effect) {
                    is SpotlightViewEffect.GoToArtist ->
                        onSuggestionClick(effect.id)
                }
            }
    }

    Spotlight(
        onAction = viewModel::onAction,
    )
}

@Composable
private fun Spotlight(
    onAction: (SpotlightViewAction) -> Unit = {},
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
            onClick = { onAction(SpotlightViewAction.ButtonClick) },
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