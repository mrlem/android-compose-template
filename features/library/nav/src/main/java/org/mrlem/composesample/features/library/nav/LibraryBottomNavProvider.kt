package org.mrlem.composesample.features.library.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import org.mrlem.android.core.feature.nav.BottomNavProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryBottomNavProvider @Inject constructor() : BottomNavProvider {

    override val navBarItem = BottomNavProvider.Item(
        index = 1,
        labelResId = R.string.library_bottomnav_label,
        icon = Icons.Filled.Home,
        route = LibraryDestination.route,
    )

}