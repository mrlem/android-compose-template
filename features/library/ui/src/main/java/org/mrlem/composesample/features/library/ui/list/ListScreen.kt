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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberSwipeToDismissBoxState
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.features.library.ui.R
import org.mrlem.composesample.theme.Theme

@Composable
internal fun ListScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    viewModel: ListViewModel = hiltViewModel(),
    onItemSelect: (id: Long) -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val errorMessage = stringResource(R.string.library_error)

    LaunchedEffect(Unit) {
        viewModel.effects
            .collect { effect ->
                when (effect) {
                    is ListViewEffect.GoToItem ->
                        onItemSelect(effect.id)

                    is ListViewEffect.ShowError ->
                        snackbarHostState.showSnackbar(errorMessage)
                }
            }
    }

    ListScreen(
        modifier = modifier,
        state = state,
        onAction = viewModel::onAction,
    )
}

@Composable
private fun ListScreen(
    state: ListViewState,
    onAction: (ListViewAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
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
            placeholder = {
                Text(
                    text = stringResource(id = R.string.library_search_action),
                )
            },
            trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun List(
    state: ListViewState,
    modifier: Modifier = Modifier,
    onAction: (ListViewAction) -> Unit = {},
) {
    val listState = rememberLazyListState()
    val showShadow by remember {
        derivedStateOf { listState.canScrollBackward }
    }

    Box(
        modifier = modifier,
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                items = state.items,
                key = { item -> (item.onClickAction as ListViewAction.ItemClick).itemId },
            ) { item ->
                val dismissState = rememberSwipeToDismissBoxState(
                    confirmValueChange = { dismissValue ->
                        if (dismissValue == SwipeToDismissBoxValue.EndToStart) {
                            val action = item.onClickAction as ListViewAction.ItemClick
                            onAction(ListViewAction.ItemDismiss(action.itemId))
                            true
                        } else {
                            false
                        }
                    },
                )

                SwipeToDismissBox(
                    state = dismissState,
                    enableDismissFromStartToEnd = false,
                    backgroundContent = {
                        if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart) {
                            RemoveIcon()
                        }
                    },
                ) {
                    ListItem(
                        viewState = item,
                        onAction = onAction,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background),
                    )
                }
            }
        }

        Shadow(
            visible = showShadow,
            modifier = Modifier
                .align(Alignment.TopCenter),
        )

        ImportButton(
            onAction = onAction,
            modifier = Modifier
                .padding(Theme.size.medium)
                .align(Alignment.BottomEnd),
        )
    }
}

@Composable
private fun ImportButton(
    onAction: (ListViewAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(
        onClick = { onAction(ListViewAction.ImportRandomClick) },
        shape = CircleShape,
        modifier = modifier,
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(R.string.library_import_action))
    }
}

@Composable
private fun RemoveIcon() {
    Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = stringResource(R.string.library_remove_action),
        tint = MaterialTheme.colorScheme.onErrorContainer,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.errorContainer)
            .wrapContentSize(Alignment.CenterEnd)
            .padding(Theme.size.small),
    )
}

@Composable
private fun Shadow(
    visible: Boolean,
    modifier: Modifier = Modifier,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
        modifier = modifier,
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

@UiModePreviews
@Composable
@Suppress("MagicNumber")
private fun Preview() {
    Theme {
        Surface {
            ListScreen(
                state = ListViewState(
                    items = listOf(
                        ListItemViewState(
                            label = "Georges Plop",
                            onClickAction = ListViewAction.ItemClick(1L),
                        ),
                        ListItemViewState(
                            label = "Jacques Brel",
                            onClickAction = ListViewAction.ItemClick(2L),
                        ),
                        ListItemViewState(
                            label = "Joe Dassin",
                            onClickAction = ListViewAction.ItemClick(3L),
                        ),
                    ),
                ),
                onAction = {},
            )
        }
    }
}
