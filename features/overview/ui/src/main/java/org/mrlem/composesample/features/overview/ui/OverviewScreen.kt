package org.mrlem.composesample.features.overview.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

@Composable
internal fun OverviewScreen(
    viewModel: OverviewViewModel = hiltViewModel(),
    onSuggestionClick: (itemId: Long) -> Unit = {},
) {
    val state by viewModel.state.collectAsState()

    Overview(
        state = state,
        onSuggestionClick = { state.suggestionId?.let { onSuggestionClick(it) } },
    )
}

@Composable
private fun Overview(
    state: OverviewViewState,
    onSuggestionClick: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.size.medium),
        modifier = Modifier
            .fillMaxSize()
            .padding(Theme.size.large),
    ) {
        Text(
            text = stringResource(R.string.overview_title),
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = stringResource(R.string.overview_description),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .alpha(0.4f)
                .weight(1f),
        )

        state.suggestionId?.let { id ->
            Text(
                text = stringResource(R.string.overview_selection),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(bottom = Theme.size.small),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSuggestionClick() },
            ) {
                state.suggestionName?.let { name ->
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(vertical = Theme.size.small)
                            .align(Alignment.CenterHorizontally),
                    )
                }
                DetailImage(
                    modifier = Modifier
                        .size(250.dp)
                        .align(Alignment.CenterHorizontally),
                    image = state.suggestionImage,
                )
            }
        }
    }
}

@Composable
private fun DetailImage(
    modifier: Modifier = Modifier,
    image: String?,
) {
    var showLoader by remember { mutableStateOf(false) }
    image?.let { image ->
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            onLoading = { showLoader = true },
            onError = { showLoader = false },
            onSuccess = { showLoader = false },
            modifier = modifier,
        )
    }

    val localInspectionMode = LocalInspectionMode.current
    if (showLoader || localInspectionMode) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Overview(
                state = OverviewViewState(
                    suggestionName = "Saturn",
                    suggestionId = 123,
                ),
            )
        }
    }
}