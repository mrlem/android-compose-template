package org.mrlem.sample.compose.features.home.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.mrlem.sample.compose.features.home.domain.SayHelloUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    sayHelloUseCase: SayHelloUseCase,
) : ViewModel() {

    val state: HomeViewState = HomeViewState(
        label = sayHelloUseCase(),
    )

}