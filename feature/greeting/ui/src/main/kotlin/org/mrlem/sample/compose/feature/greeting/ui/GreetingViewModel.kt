package org.mrlem.sample.compose.feature.greeting.ui

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import org.mrlem.sample.compose.arch.ui.BaseViewModel
import org.mrlem.sample.compose.feature.greeting.domain.SampleManager
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
    private val sampleManager: SampleManager,
) : BaseViewModel<GreetingState>(
    initialState = GreetingState(),
) {

    suspend fun incrementCounter() {
        delay(1000L)
        updateState { copy(counter = sampleManager.act()) }
    }

}