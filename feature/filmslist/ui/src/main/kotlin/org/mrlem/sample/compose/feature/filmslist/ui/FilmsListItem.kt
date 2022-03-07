package org.mrlem.sample.compose.feature.filmslist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.design.theme.Typography
import org.mrlem.sample.compose.feature.ghibli.domain.model.Film

@Composable
fun FilmsListItem(
    film: Film,
    onClick: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .clickable { onClick(film.id) }
            .padding(16.dp)
            .fillMaxWidth(),
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

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeSampleTheme {
        FilmsListItem(
            Film(
                id = "123",
                title = "Le Voyage de Chihiro",
                originalTitle = "千と千尋の神隠し",
                originalTitleRomanised = "Sen to Chihiro no kamikakushi",
                description = "Le film raconte l'histoire de Chihiro, une fillette de dix ans qui, alors qu'elle se rend en famille vers sa nouvelle maison, entre dans le monde des esprits. Après la transformation de ses parents en porcs par la sorcière Yubaba, Chihiro prend un emploi dans l'établissement de bains de la sorcière pour retrouver ses parents et regagner le monde des humains.",
                director = "Hayao Miyazaki",
                releaseDate = "2001",
                image = "",
            ),
        )
    }
}