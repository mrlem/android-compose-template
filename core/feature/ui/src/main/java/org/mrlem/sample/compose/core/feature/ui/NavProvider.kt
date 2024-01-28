package org.mrlem.sample.compose.core.feature.ui

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavProvider {

    fun graph(
        builder: NavGraphBuilder,
        navController: NavController,
        snackbarHostState: SnackbarHostState,
    )

}