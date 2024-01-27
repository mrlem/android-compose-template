package org.mrlem.sample.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.mrlem.sample.compose.core.ui.base.NavGraphProvider

@Composable
fun MainWindow(navGraphProviders: Set<NavGraphProvider>) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "library",
    ) {
        navGraphProviders.forEach { subGraph ->
            subGraph.merge(this, navController)
        }
    }
}