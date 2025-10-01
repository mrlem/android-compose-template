package org.mrlem.composesample.features.library.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.mrlem.composesample.theme.Theme

@Composable
internal fun <Action> ListItem(
    viewState: ListItemViewState<Action>,
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
            .padding(Theme.size.medium),
    ){
        Text(
            text = viewState.label,
        )
    }
}