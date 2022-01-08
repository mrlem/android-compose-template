package org.mrlem.sample.compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GreetingScreen(viewModel: GreetingViewModel = viewModel()) {
    GreetingLayout(
        state = viewModel.state.value,
        onClick = { viewModel.incrementCounter() }
    )
}