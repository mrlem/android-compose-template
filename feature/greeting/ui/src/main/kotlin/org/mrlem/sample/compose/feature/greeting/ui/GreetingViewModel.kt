package org.mrlem.sample.compose.feature.greeting.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.mrlem.sample.compose.arch.ui.StateDelegate
import org.mrlem.sample.compose.arch.ui.StateProvider
import org.mrlem.sample.compose.feature.ghibli.domain.repository.GhibliRepository
import org.mrlem.sample.compose.feature.greeting.domain.GreetingManager
import org.mrlem.sample.compose.feature.greeting.domain.repository.GreetingRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GreetingViewModel @Inject constructor(
    private val ghibliRepository: GhibliRepository,
    private val greetingRepository: GreetingRepository,
    private val greetingManager: GreetingManager,
) : ViewModel(),
    StateProvider<GreetingState> by StateDelegate(GreetingState())
{

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
        viewModelScope.launch {
            greetingManager.greet()
        }

        viewModelScope.launch {
            try {
                val film = ghibliRepository.getFilm("58611129-2dbc-4a81-a72f-77ddfc1b1b49")
                println("plop: film=$film")
            } catch (e: Exception) {
                println("plop: film retrieval failed: ${e.localizedMessage}")
            }
        }
    }

}