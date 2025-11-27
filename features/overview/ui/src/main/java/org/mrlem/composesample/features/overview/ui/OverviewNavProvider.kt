package org.mrlem.composesample.features.overview.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.mrlem.android.core.feature.nav.Navigator
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.features.library.nav.LibraryDestination
import org.mrlem.composesample.features.overview.nav.OverviewDestination
import org.mrlem.composesample.features.overview.nav.R
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class OverviewNavProvider @Inject constructor(
    private val navigator: Navigator,
) : NavProvider() {

    override val startRoute = OverviewDestination.route
    override val navBarItem = BottomBarItem(
        index = 0,
        labelResId = R.string.overview_bottomnav_label,
        icon = Icons.Filled.Info,
        route = OverviewDestination.route,
    )

    override fun graph(
        builder: NavGraphBuilder,
        snackbarHostState: SnackbarHostState,
        innerPadding: PaddingValues,
    ) = builder.run {
        composable(OverviewDestination.route) {
            OverviewScreen(
                onSuggestionClick = { itemId ->
                    navigator.navigate(LibraryDestination(itemId = itemId)) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}