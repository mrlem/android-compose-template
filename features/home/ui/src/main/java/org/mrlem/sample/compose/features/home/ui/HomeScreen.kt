package org.mrlem.sample.compose.features.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.ComposeSampleTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Home(state)
}

@Composable
private fun Home(state: HomeViewState) {
    Text(
        text = state.label,
        modifier = Modifier
            .fillMaxSize(),
    )
}

@UiModePreviews
@Composable
private fun Preview() {
    ComposeSampleTheme {
        Home(
            state = HomeViewState(
                label = "Plop",
            ),
        )
    }
}