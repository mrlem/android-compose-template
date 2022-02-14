package org.mrlem.sample.compose.feature.greeting.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GreetingLayout(
    state: GreetingState = GreetingState(),
    onClick: () -> Unit = {},
) {
    Text(
        text = "Hello ${state.counter}!",
        modifier = Modifier
            .clickable { onClick() }
            .padding(12.dp),
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    GreetingLayout()
}