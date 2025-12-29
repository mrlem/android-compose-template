package org.mrlem.composesample.features.library.nav

import kotlinx.serialization.Serializable
import org.mrlem.android.core.feature.nav.MainNavKey

@Serializable
data class BookmarkKey(
    val itemId: Long,
) : MainNavKey