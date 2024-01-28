package org.mrlem.sample.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.mrlem.sample.compose.core.feature.nav.BottomNavProvider
import org.mrlem.sample.compose.core.feature.ui.NavProvider

@Composable
fun MainWindow(
    navProviders: Set<NavProvider>,
    bottomNavProviders: Set<BottomNavProvider>,
) {
    val navController = rememberNavController()
    val items = bottomNavProviders
        .mapNotNull { it.navBarItem }
        .sortedBy { it.index }
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            MainNavBar(
                items = items,
                navController = navController,
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "spotlight",
            modifier = Modifier
                .padding(innerPadding),
        ) {
            navProviders.forEach { subGraph ->
                subGraph.graph(this, navController, snackbarHostState)
            }
        }
    }
}