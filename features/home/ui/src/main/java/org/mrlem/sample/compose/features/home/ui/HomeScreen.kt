package org.mrlem.sample.compose.features.home.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.mrlem.sample.compose.core.ui.theme.ComposeSampleTheme

@Composable
fun HomeScreen() {
    Text(
        text = "Hello!",
        modifier = Modifier
            .fillMaxSize(),
    )
}

@Preview(showBackground = true)
@Composable
fun HomeComponentPreview() {
    ComposeSampleTheme {
        HomeScreen()
    }
}