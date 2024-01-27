package org.mrlem.sample.compose.features.spotlight.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.ComposeSampleTheme
import org.mrlem.sample.compose.core.ui.theme.Theme

@Composable
fun SpotlightScreen(
    onLibraryItemClicked: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Theme.size.medium),
        modifier = Modifier
            .fillMaxSize()
            .padding(Theme.size.medium),
    ) {
        Text(
            text = "Spotlight",
            modifier = Modifier
                .weight(1f),
        )
        Button(
            onClick = { onLibraryItemClicked() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Go to library item")
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    ComposeSampleTheme {
        Surface {
            SpotlightScreen()
        }
    }
}