package org.mrlem.composesample.features.library.ui.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.theme.Theme

@Composable
internal fun ListScreen(
    snackbarHostState: SnackbarHostState,
    viewModel: ListViewModel = hiltViewModel(),
    onItemSelect: (id: Long) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effects
            .collect { effect ->
                when (effect) {
                    is ListViewEffect.GoToItem ->
                        onItemSelect(effect.id)
                    is ListViewEffect.ShowError ->
                        snackbarHostState.showSnackbar("Failed to retrieve data")
                }
            }
    }

    LaunchedEffect(Unit) {
        viewModel.handleRedirections()
    }

    List(
        state = state,
        modifier = Modifier
            .fillMaxSize(),
        onAction = viewModel::onAction,
    )
}

@Composable
private fun List(
    state: ListViewState,
    modifier: Modifier = Modifier,
    onAction: (ListViewAction) -> Unit = {},
) {
    Box(
        modifier = modifier,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(state.items) {
                ListItem(
                    viewState = it,
                    onAction = onAction,
                )
            }
        }

        FloatingActionButton(
            onClick = { onAction(ListViewAction.ImportRandomClick) },
            shape = CircleShape,
            modifier = Modifier
                .padding(Theme.size.medium)
                .align(Alignment.TopEnd),
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Import random bookmark")
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            List(
                state = ListViewState(
                    items = listOf(
                        ListItemViewState(
                            label = "Georges Brassens",
                        ),
                        ListItemViewState(
                            label = "Jacques Brel",
                        ),
                        ListItemViewState(
                            label = "Joe Dassin",
                        ),
                    ),
                ),
            )
        }
    }
}