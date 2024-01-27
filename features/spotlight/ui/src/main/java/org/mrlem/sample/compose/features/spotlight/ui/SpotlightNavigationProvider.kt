package org.mrlem.sample.compose.features.spotlight.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.sample.compose.core.ui.base.NavGraphProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightNavigationProvider @Inject constructor() : NavGraphProvider {

    override fun merge(builder: NavGraphBuilder, navController: NavController) =
        builder.run {
            composable("spotlight") {
                SpotlightScreen()
            }
        }

}