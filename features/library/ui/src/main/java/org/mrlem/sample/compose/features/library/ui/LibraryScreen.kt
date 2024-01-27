package org.mrlem.sample.compose.features.library.ui

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
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.ComposeSampleTheme
import org.mrlem.sample.compose.core.ui.theme.Theme

@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel = hiltViewModel(),
    onSpotlightClicked: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    Library(
        state = state,
        onSpotlightClicked = onSpotlightClicked,
    )
}

@Composable
private fun Library(
    state: LibraryViewState,
    onSpotlightClicked: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.size.medium),
        modifier = Modifier
            .fillMaxSize()
            .padding(Theme.size.medium),
    ) {
        Text(
            text = state.label,
            modifier = Modifier
                .weight(1f),
        )
        Button(
            onClick = { onSpotlightClicked() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Spotlight")
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    ComposeSampleTheme {
        Surface {
            Library(
                state = LibraryViewState(
                    label = "Plop",
                ),
            )
        }
    }
}