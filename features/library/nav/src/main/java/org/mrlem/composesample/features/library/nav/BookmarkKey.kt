package org.mrlem.composesample.features.library.nav

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class BookmarkKey(
    val itemId: Long,
) : NavKey