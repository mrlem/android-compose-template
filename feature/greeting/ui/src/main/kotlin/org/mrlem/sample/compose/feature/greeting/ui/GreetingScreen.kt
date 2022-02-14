package org.mrlem.sample.compose.feature.greeting.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun GreetingScreen(viewModel: GreetingViewModel = viewModel()) {
    val scope = rememberCoroutineScope()

    GreetingLayout(
        state = viewModel.state.value,
        onClick = { scope.launch { viewModel.incrementCounter() } },
    )
}