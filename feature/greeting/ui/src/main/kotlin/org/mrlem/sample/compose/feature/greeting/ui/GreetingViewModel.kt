package org.mrlem.sample.compose.feature.greeting.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.ui.BaseViewModel
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
    private val greetingRepository: GreetingRepository,
) : BaseViewModel<GreetingState>(
    initialState = GreetingState(),
) {

    init {
        viewModelScope.launch(Dispatchers.Main) {
            greetingRepository.greetings
                .collect { greetings ->
                    updateState { copy(counter = greetings.size) }
                }
        }
    }

    suspend fun incrementCounter() {
        greetingRepository.add("Plop")
    }

}