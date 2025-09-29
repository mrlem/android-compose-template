package org.mrlem.android.core.feature.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder

abstract class NavProvider {

    data class BottomBarItem(
        val index: Int,
        @StringRes val labelResId: Int,
        val icon: ImageVector,
        val route: String,
    )

    open val startRoute: String? = null
    abstract val navBarItem: BottomBarItem?

    abstract fun graph(
        builder: NavGraphBuilder,
        snackbarHostState: SnackbarHostState,
        innerPadding: PaddingValues = PaddingValues(0.dp),
    )

}