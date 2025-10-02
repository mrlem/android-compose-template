package org.mrlem.composesample.features.overview.ui

import androidx.compose.runtime.Immutable

@Immutable
internal data class OverviewViewState(
    val suggestionName: String? = null,
    val suggestionImage: String? = null,
    val suggestionId: Long? = null,
)