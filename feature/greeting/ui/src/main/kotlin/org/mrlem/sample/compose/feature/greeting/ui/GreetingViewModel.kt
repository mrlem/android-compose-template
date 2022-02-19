package org.mrlem.sample.compose.feature.greeting.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.ui.BaseViewModel
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import timber.log.Timber
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
                    Timber.d("received update")
                    updateState { copy(counter = greetings.size) }
                }
        }
    }

    fun incrementCounter() {
        Timber.d("adding value")
        viewModelScope.launch(Dispatchers.IO) {
            greetingRepository.add("Plop")
        }
    }

}