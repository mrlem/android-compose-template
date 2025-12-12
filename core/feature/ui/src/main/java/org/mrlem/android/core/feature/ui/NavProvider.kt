package org.mrlem.android.core.feature.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

abstract class NavProvider {

    data class BottomBarItem(
        val index: Int,
        @StringRes val labelResId: Int,
        val icon: ImageVector,
        val key: NavKey,
    )

    open val startKey: NavKey? = null
    abstract val navBarItem: BottomBarItem?
    abstract val entryBuilders: EntryProviderScope<NavKey>.(SnackbarHostState, PaddingValues) -> Unit
}