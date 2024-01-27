package org.mrlem.sample.compose.features.library.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.sample.compose.core.ui.base.NavGraphProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryNavigationProvider @Inject constructor() : NavGraphProvider {

    override fun merge(builder: NavGraphBuilder, navController: NavController) =
        builder.run {
            composable("library") {
                LibraryScreen(
                    onSpotlightClicked = { navController.navigate("spotlight") }, // TODO - obtain destination
                )
            }
        }

}