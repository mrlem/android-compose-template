package org.mrlem.sample.compose.core.ui.base

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavProvider {

    val navBarItem: NavBarItem?

    fun graph(
        builder: NavGraphBuilder,
        navController: NavController,
    )

}