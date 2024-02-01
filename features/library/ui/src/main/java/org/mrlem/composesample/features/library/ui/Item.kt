package org.mrlem.composesample.features.library.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import org.mrlem.composesample.theme.Theme

@Composable
internal fun <Action> Item(
    viewState: ItemViewState<Action>,
    onAction: (Action) -> Unit,
) {
    Column(
        modifier = Modifier
            .then(
                viewState.onClickAction
                    ?.let { Modifier.clickable { onAction(it) }}
                    ?: Modifier
            )
            .fillMaxWidth()
            .padding(Theme.size.small),
    ){
        Text(
            text = viewState.label,
        )
        Text(
            text = viewState.description,
            modifier = Modifier
                .alpha(0.4f),
        )
    }
}