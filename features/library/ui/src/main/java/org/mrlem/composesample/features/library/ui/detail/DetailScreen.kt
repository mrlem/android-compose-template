package org.mrlem.composesample.features.library.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

private const val DESCRIPTION_ALPHA = 0.4f

@Composable
internal fun DetailScreen(viewModel: DetailViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

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
                    .alpha(DESCRIPTION_ALPHA),
            )
        }

        DetailImage(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.CenterHorizontally),
            image = state.image,
        )
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