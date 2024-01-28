package org.mrlem.sample.compose.core.feature.nav

import androidx.compose.ui.graphics.vector.ImageVector

interface BottomNavProvider {

    data class Item(
        val index: Int,
        val label: String,
        val icon: ImageVector,
        val route: String,
    )

    val navBarItem: Item?

}