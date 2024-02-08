package org.mrlem.android.core.feature.ui

import androidx.annotation.StringRes
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavProvider {

    data class BottomBarItem(
        val index: Int,
        @StringRes val labelResId: Int,
        val icon: ImageVector,
        val route: String,
        val isStart: Boolean,
    )

    val navBarItem: BottomBarItem?

    fun graph(
        builder: NavGraphBuilder,
        snackbarHostState: SnackbarHostState,
    )

}