package org.mrlem.sample.compose.design.demo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mrlem.sample.compose.design.theme.Palette.Purple200
import org.mrlem.sample.compose.design.theme.Palette.Purple500
import org.mrlem.sample.compose.design.theme.Palette.Purple700
import org.mrlem.sample.compose.design.theme.Palette.Teal200

private val colors = listOf(
    "Purple200" to Purple200,
    "Purple500" to Purple500,
    "Purple700" to Purple700,
    "Teal200" to Teal200,
)

@Composable
@ExperimentalFoundationApi
fun PaletteTab() {
    LazyVerticalGrid(
        cells = GridCells.Fixed(4),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(colors) { (name, color) ->
            Text(
                text = name,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                color = if (color.luminance() * color.alpha + (1 - color.alpha) > 0.5f ) Color.Black else Color.White,
                modifier = Modifier
                    .padding(4.dp)
                    .background(color)
                    .padding(horizontal = 8.dp, vertical = 16.dp),
            )
        }
    }
}