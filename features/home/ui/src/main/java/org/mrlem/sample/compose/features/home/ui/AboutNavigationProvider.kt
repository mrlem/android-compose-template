package org.mrlem.sample.compose.features.home.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.sample.compose.core.ui.base.NavGraphProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class AboutNavigationProvider @Inject constructor() : NavGraphProvider {

    override fun merge(builder: NavGraphBuilder, navController: NavController) =
        builder.run {
            composable("home") {
                HomeScreen(
                    onAboutClicked = { navController.navigate("about") }, // TODO - obtain destination
                )
            }
        }

}