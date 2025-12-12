package org.mrlem.composesample

import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.mrlem.android.core.feature.nav.NavigationLaunchedEffect
import org.mrlem.android.core.feature.nav.Navigator
import org.mrlem.android.core.feature.ui.NavProvider

@Composable
fun MainWindow(
    navProviders: Set<NavProvider>,
    navigator: Navigator,
) {
    val backStack = rememberNavBackStack(navProviders.firstNotNullOf { it.startKey })

    val items = navProviders
        .mapNotNull { it.navBarItem }
        .sortedBy { it.index }
    val snackbarHostState = remember { SnackbarHostState() }

    NavigationLaunchedEffect(
        navigator = navigator,
        backStack = backStack,
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        bottomBar = {
            MainNavBar(
                items = items,
                navigator = navigator,
                backStack = backStack,
                modifier = Modifier
                    .imePadding()
                    .systemBarsPadding(),
            )
        },
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider = entryProvider {
                navProviders.forEach {
                    it.entryBuilders.invoke(this, snackbarHostState, innerPadding)
                }
            },
        )
    }
}