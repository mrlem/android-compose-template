package org.mrlem.sample.compose.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.mrlem.sample.compose.design.theme.Palette.BlueDeep
import org.mrlem.sample.compose.design.theme.Palette.BlueDeeper

private val DarkColorPalette = darkColors(
    primary = BlueDeep,
    primaryVariant = BlueDeeper,
    secondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = BlueDeep,
    primaryVariant = BlueDeeper,
    secondary = Color.White,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeSampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}