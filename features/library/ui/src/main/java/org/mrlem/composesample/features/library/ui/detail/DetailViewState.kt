package org.mrlem.composesample.features.library.ui.detail

import androidx.compose.runtime.Immutable

@Immutable
internal data class DetailViewState(
    val name: String = "",
    val image: String? = null,
)