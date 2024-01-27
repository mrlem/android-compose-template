package org.mrlem.sample.compose.features.spotlight.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.sample.compose.core.ui.base.NavBarItem
import org.mrlem.sample.compose.core.ui.base.NavProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightNavigationProvider @Inject constructor() : NavProvider {

    override val navBarItem = NavBarItem(
        index = 0,
        label = "Spotlight",
        icon = Icons.Filled.Info,
        route = "spotlight",
    )

    override fun graph(builder: NavGraphBuilder, navController: NavController) =
        builder.run {
            composable("spotlight") {
                SpotlightScreen(
                    onSuggestionClick = {
                        navController.navigate("library?artistId=2") {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    },
                )
            }
        }

}