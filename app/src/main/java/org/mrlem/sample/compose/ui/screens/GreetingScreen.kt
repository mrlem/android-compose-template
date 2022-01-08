package org.mrlem.sample.compose.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.mrlem.sample.compose.ui.theme.ComposeSampleTheme

@Composable
fun GreetingScreen(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeSampleTheme {
        GreetingScreen("Android")
    }
}