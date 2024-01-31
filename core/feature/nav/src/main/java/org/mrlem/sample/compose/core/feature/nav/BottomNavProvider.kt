package org.mrlem.sample.compose.core.feature.nav

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavProvider {

    data class Item(
        val index: Int,
        @StringRes val labelResId: Int,
        val icon: ImageVector,
        val route: String,
    )

    val navBarItem: Item?

}