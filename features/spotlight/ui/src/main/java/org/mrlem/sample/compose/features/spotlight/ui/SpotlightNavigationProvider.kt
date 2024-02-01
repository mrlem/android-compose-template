package org.mrlem.sample.compose.features.spotlight.ui

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.android.core.feature.nav.navigate
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.sample.compose.features.library.nav.LibraryDestination
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class SpotlightNavigationProvider @Inject constructor() : NavProvider {

    override fun graph(builder: NavGraphBuilder, navController: NavController, snackbarHostState: SnackbarHostState) = builder.run {
        composable("spotlight") {
            SpotlightScreen(
                onSuggestionClick = { artistId ->
                    navController.navigate(LibraryDestination(artistId = artistId)) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },
            )
        }
    }

}