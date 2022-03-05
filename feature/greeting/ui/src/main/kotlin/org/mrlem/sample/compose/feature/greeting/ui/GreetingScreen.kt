package org.mrlem.sample.compose.feature.greeting.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GreetingScreen(viewModel: GreetingViewModel = viewModel()) {
    GreetingLayout(
        state = viewModel.state,
        onClick = { viewModel.incrementCounter() },
    )
}