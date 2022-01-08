package org.mrlem.sample.compose.ui.screens

import dagger.hilt.android.lifecycle.HiltViewModel
import org.mrlem.sample.compose.arch.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor() : BaseViewModel<GreetingState>(
    initialState = GreetingState(),
) {

    fun incrementCounter() {
        updateState { copy(counter = counter + 1) }
    }

}