package org.mrlem.sample.compose.features.home.ui

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
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onAboutClicked: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    Home(
        state = state,
        onAboutClicked = onAboutClicked,
    )
}

@Composable
private fun Home(
    state: HomeViewState,
    onAboutClicked: () -> Unit = {},
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
            onClick = { onAboutClicked() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "About")
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    ComposeSampleTheme {
        Surface {
            Home(
                state = HomeViewState(
                    label = "Plop",
                ),
            )
        }
    }
}