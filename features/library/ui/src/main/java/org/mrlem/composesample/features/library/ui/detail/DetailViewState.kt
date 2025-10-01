package org.mrlem.composesample.features.library.ui.detail

import androidx.compose.runtime.Immutable

@Immutable
internal data class DetailViewState(
    val name: String = "",
    val description: String? = null,
    val image: String? = null,
)