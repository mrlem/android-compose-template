package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilmDetailLayout(
    state: FilmDetailState = FilmDetailState(),
    onFavoriteClick: () -> Unit = {},
) {
    Row {
        Text(
            text = state.title,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp),
        )
        Image(
            painter = painterResource(state.favoriteDrawable),
            contentDescription = stringResource(state.favoriteText),
            colorFilter = ColorFilter.tint(Color.Gray),
            modifier = Modifier
                .clickable { onFavoriteClick() }
                .padding(12.dp)
                .wrapContentSize(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    FilmDetailLayout()
}