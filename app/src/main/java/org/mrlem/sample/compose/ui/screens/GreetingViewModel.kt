package org.mrlem.sample.compose.ui.screens

import org.mrlem.sample.compose.arch.BaseViewModel

class GreetingViewModel : BaseViewModel<GreetingState>(
    initialState = GreetingState(),
) {

    fun incrementCounter() {
        updateState { copy(counter = counter + 1) }
    }

}