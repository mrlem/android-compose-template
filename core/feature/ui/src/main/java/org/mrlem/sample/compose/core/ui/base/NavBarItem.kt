package org.mrlem.sample.compose.core.ui.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val index: Int = 0,
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = "",
)