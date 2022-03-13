package org.mrlem.sample.compose.feature.filmslist.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.design.theme.Typography
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

@Composable
internal fun Item(
    film: Film,
    onClick: (String) -> Unit = {},
) {
    Row(
        modifier = Modifier
            .clickable { onClick(film.id) }
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        AsyncImage(
            model = film.coverImage,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .shadow(elevation = 8.dp)
                .width(64.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
        ) {
            Text(
                text = film.title,
                style = Typography.body2,
            )
            Text(
                text = film.originalTitle,
                color = Color.LightGray,
                style = Typography.caption,
            )
        }
    }
    Divider(color = Color.LightGray)
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeSampleTheme {
        Item(
            Film(
                id = "123",
                title = "Le Voyage de Chihiro",
                originalTitle = "千と千尋の神隠し",
                originalTitleRomanised = "Sen to Chihiro no kamikakushi",
                description = "Le film raconte l'histoire de Chihiro, une fillette de dix ans qui, alors qu'elle se rend en famille vers sa nouvelle maison, entre dans le monde des esprits. Après la transformation de ses parents en porcs par la sorcière Yubaba, Chihiro prend un emploi dans l'établissement de bains de la sorcière pour retrouver ses parents et regagner le monde des humains.",
                director = "Hayao Miyazaki",
                releaseDate = "2001",
                coverImage = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rtGDOeG9LzoerkDGZF9dnVeLppL.jpg",
                bannerImage = "https://image.tmdb.org/t/p/original/etqr6fOOCXQOgwrQXaKwenTSuzx.jpg",
            )
        )
    }
}