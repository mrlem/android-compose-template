package org.mrlem.sample.compose.features.about.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.mrlem.sample.compose.core.ui.base.UiModePreviews
import org.mrlem.sample.compose.core.ui.theme.ComposeSampleTheme
import org.mrlem.sample.compose.core.ui.theme.Theme

@Composable
fun AboutScreen() {
    Text(
        text = "About",
        modifier = Modifier
            .fillMaxSize()
            .padding(Theme.size.medium),
    )
}

@UiModePreviews
@Composable
private fun Preview() {
    ComposeSampleTheme {
        Surface {
            AboutScreen()
        }
    }
}