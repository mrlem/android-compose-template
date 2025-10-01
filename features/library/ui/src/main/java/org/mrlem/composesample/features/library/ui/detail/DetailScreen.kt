package org.mrlem.composesample.features.library.ui.detail

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

@Composable
internal fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Detail(
        state = state,
    )
}

@Composable
private fun Detail(state: DetailViewState) {
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
                    top = Theme.size.larger,
                    bottom = Theme.size.small,
                    start = Theme.size.medium,
                    end = Theme.size.medium,
                ),
        )
        state.description?.let { description ->
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = Theme.size.medium,
                    )
                    .alpha(0.4f),
            )
        }

        var showLoader by remember { mutableStateOf(false) }
        state.image?.let { image ->
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                onLoading = { showLoader = true },
                onError = { showLoader = false },
                onSuccess = { showLoader = false },
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally),
            )
        }

        val localInspectionMode = LocalInspectionMode.current
        if (showLoader || localInspectionMode) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(250.dp),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Detail(
                state = DetailViewState(
                    name = "Saturn",
                    description = "Saturn is the sixth planet from the Sun.",
                ),
            )
        }
    }
}