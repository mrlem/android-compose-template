package org.mrlem.sample.compose.features.library.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import org.mrlem.sample.compose.core.feature.nav.BottomNavProvider
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryBottomNavProvider @Inject constructor() : BottomNavProvider {

    override val navBarItem = BottomNavProvider.Item(
        index = 1,
        label = "Library",
        icon = Icons.Filled.List,
        route = "library",
    )

}