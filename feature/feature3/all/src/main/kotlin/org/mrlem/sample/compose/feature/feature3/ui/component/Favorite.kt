package org.mrlem.sample.compose.feature.feature3.ui.component

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import org.mrlem.sample.compose.feature.feature3.ui.FavoriteViewState

@Composable
internal fun Favorite(
    state: FavoriteViewState,
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {},
) {
    FloatingActionButton(
        onClick = { onFavoriteClick() },
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(state.drawable),
            tint = state.color,
            contentDescription = stringResource(state.text),
        )
    }
}