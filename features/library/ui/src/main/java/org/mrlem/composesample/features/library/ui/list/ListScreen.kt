package org.mrlem.composesample.features.library.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
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

    ListScreen(
        state = state,
        onAction = viewModel::onAction,
    )
}

@Composable
private fun ListScreen(
    state: ListViewState,
    onAction: (ListViewAction) -> Unit,
) {
    Column {
        var fieldValue by remember {
            mutableStateOf(TextFieldValue(state.filter))
        }

        TextField(
            value = fieldValue,
            singleLine = true,
            onValueChange = {
                fieldValue = it
                onAction(ListViewAction.FilterChange(it.text))
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
            ),
            placeholder = { Text("Filter articles") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Theme.size.medium,
                    top = Theme.size.medium,
                    end = Theme.size.medium,
                ),
        )

        List(
            state = state,
            modifier = Modifier
                .fillMaxSize(),
            onAction = onAction,
        )
    }
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
        val listState = rememberLazyListState()

        val showShadow by remember {
            derivedStateOf { listState.canScrollBackward }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            LazyColumn(
                state = listState,
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

            AnimatedVisibility(
                visible = showShadow,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.TopCenter),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Theme.size.medium)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.background,
                                    Color.Transparent,
                                ),
                            ),
                        ),
                )
            }
        }

        FloatingActionButton(
            onClick = { onAction(ListViewAction.ImportRandomClick) },
            shape = CircleShape,
            modifier = Modifier
                .padding(Theme.size.medium)
                .align(Alignment.BottomEnd),
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
            ListScreen(
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
                onAction = {},
            )
        }
    }
}