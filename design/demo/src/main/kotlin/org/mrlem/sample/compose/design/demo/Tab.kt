package org.mrlem.sample.compose.design.demo

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable

enum class Tab(
    @StringRes val title: Int,
    val creator: @Composable () -> Unit,
) {

    @ExperimentalFoundationApi
    Palette(
        R.string.tab_palette_title,
        { PaletteTab() },
    ),
    Typography (
        R.string.tab_typography_title,
        { TypographyTab() }
    ),

}