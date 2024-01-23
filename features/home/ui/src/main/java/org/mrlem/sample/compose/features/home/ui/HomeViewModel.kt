package org.mrlem.sample.compose.features.home.ui

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val state: HomeViewState = HomeViewState(
        label = "Plop",
    )

}