package org.mrlem.sample.compose.features.library.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.sample.compose.core.ui.base.NavBarItem
import org.mrlem.sample.compose.core.ui.base.NavProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryNavigationProvider @Inject constructor() : NavProvider {

    override val navBarItem = NavBarItem(
        index = 1,
        label = "Library",
        icon = Icons.Filled.List,
        route = "library",
    )

    override fun graph(builder: NavGraphBuilder, navController: NavController) =
        builder.run {
            composable("library") {
                LibraryScreen(
                    onSpotlightClicked = {
                        navController.navigate("spotlight") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }

}