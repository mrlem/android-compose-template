package org.mrlem.composesample

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.mrlem.android.core.feature.nav.NavigationLaunchedEffect
import org.mrlem.android.core.feature.nav.Navigator
import org.mrlem.android.core.feature.ui.NavProvider

@Composable
fun MainWindow(
    navProviders: Set<NavProvider>,
    navigator: Navigator,
) {
    val navController = rememberNavController()
    val items = navProviders
        .mapNotNull { it.navBarItem }
        .sortedBy { it.index }
    val snackbarHostState = remember { SnackbarHostState() }

    NavigationLaunchedEffect(
        navigator = navigator,
        navController = navController,
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            MainNavBar(
                items = items,
                navController = navController,
                modifier = Modifier
                    .imePadding(),
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = navProviders.firstNotNullOfOrNull { it.startRoute }
                ?: throw IllegalArgumentException("no start destination defined"),
            modifier = Modifier
                .padding(innerPadding),
        ) {
            navProviders.forEach { subGraph ->
                subGraph.graph(
                    builder = this,
                    snackbarHostState = snackbarHostState,
                    innerPadding = innerPadding,
                )
            }
        }
    }
}