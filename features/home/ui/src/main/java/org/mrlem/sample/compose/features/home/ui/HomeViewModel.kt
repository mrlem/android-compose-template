package org.mrlem.sample.compose.features.home.ui

import androidx.lifecycle.ViewModel
import org.mrlem.sample.compose.features.home.domain.SayHelloUseCase

class HomeViewModel(
    sayHelloUseCase: SayHelloUseCase = SayHelloUseCase(),
) : ViewModel() {

    val state: HomeViewState = HomeViewState(
        label = sayHelloUseCase(),
    )

}