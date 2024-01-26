package org.mrlem.sample.compose.core.ui.base

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavGraphProvider {

    fun merge(
        builder: NavGraphBuilder,
        navController: NavController,
    )

}