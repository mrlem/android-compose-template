package org.mrlem.composesample.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Size internal constructor(
    val smaller: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val larger: Dp = 64.dp,
)