package org.mrlem.composesample.features.library.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.SnackbarHostState
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import org.mrlem.android.core.feature.nav.Navigator
import org.mrlem.android.core.feature.nav.Navigator.Operation.Push
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.features.library.nav.BookmarkKey
import org.mrlem.composesample.features.library.nav.BookmarksKey
import org.mrlem.composesample.features.library.nav.R
import org.mrlem.composesample.features.library.ui.detail.DetailScreen
import org.mrlem.composesample.features.library.ui.detail.DetailViewModel
import org.mrlem.composesample.features.library.ui.list.ListScreen
import se.ansman.dagger.auto.AutoBindIntoSet
import javax.inject.Inject

@AutoBindIntoSet
class LibraryNavProvider @Inject constructor(
    private val navigator: Navigator,
) : NavProvider() {

    override val navBarItem = BottomBarItem(
        index = 1,
        labelResId = R.string.library_bottomnav_label,
        icon = Icons.Filled.Home,
        key = BookmarksKey,
    )

    override val entryBuilders: EntryProviderScope<NavKey>.(SnackbarHostState, PaddingValues) -> Unit =
        { snackbarHostState, innerPadding ->
            entry<BookmarksKey> {
                ListScreen(
                    modifier = Modifier
                        .padding(innerPadding),
                    snackbarHostState = snackbarHostState,
                    onItemSelect = { id ->
                        navigator.navigate(Push(BookmarkKey(itemId = id)))
                    },
                )
            }

            entry<BookmarkKey> { key ->
                val viewModel = hiltViewModel<DetailViewModel, DetailViewModel.Factory>(
                    creationCallback = { factory -> factory.create(key) },
                )
                DetailScreen(viewModel = viewModel)
            }
        }
}