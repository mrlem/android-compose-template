package org.mrlem.sample.compose.core.feature.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavProvider {

    fun graph(
        builder: NavGraphBuilder,
        navController: NavController,
    )

}