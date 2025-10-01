package org.mrlem.composesample.features.library.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.mrlem.android.core.feature.nav.Navigator
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.library.nav.R
import org.mrlem.composesample.features.library.ui.detail.DetailDestination
import org.mrlem.composesample.features.library.ui.detail.DetailScreen
import org.mrlem.composesample.features.library.ui.list.ListDestination
import org.mrlem.composesample.features.library.ui.list.ListScreen
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryNavProvider @Inject constructor(
    private val navigator: Navigator,
) : NavProvider() {

    override val navBarItem = BottomBarItem(
        index = 1,
        labelResId = R.string.library_bottomnav_label,
        icon = Icons.Filled.Home,
        route = LibraryDestination.route,
    )

    override fun graph(builder: NavGraphBuilder, snackbarHostState: SnackbarHostState, innerPadding: PaddingValues) =
        builder.run {
            navigation(
                startDestination = ListDestination.route,
                route = LibraryDestination.route,
                arguments = LibraryDestination.args,
            ) {
                composable(
                    route = ListDestination.route,
                ) {
                    ListScreen(
                        snackbarHostState = snackbarHostState,
                        onItemSelect = { id -> navigator.navigate(DetailDestination(id)) },
                    )
                }
                composable(
                    route = DetailDestination.route,
                    arguments = DetailDestination.args,
                ) {
                    DetailScreen()
                }
            }
        }

}