package org.mrlem.composesample.features.overview.ui

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
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

@Composable
internal fun OverviewScreen(
    viewModel: OverviewViewModel = hiltViewModel(),
    onSuggestionClick: (artistId: Long) -> Unit = {},
) {
    val state by viewModel.state.collectAsState()

    Overview(
        onSuggestionClick = { state.buttonArtistId?.let { onSuggestionClick(it) } },
    )
}

@Composable
private fun Overview(
    onSuggestionClick: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.size.medium),
        modifier = Modifier
            .fillMaxSize()
            .padding(Theme.size.medium),
    ) {
        Text(
            text = stringResource(R.string.overview_title),
        )
        Text(
            text = stringResource(R.string.overview_description),
            modifier = Modifier
                .alpha(0.4f)
                .weight(1f),
        )
        Button(
            onClick = { onSuggestionClick() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        ) {
            Text(
                text = stringResource(R.string.overview_cta),
            )
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Overview()
        }
    }
}