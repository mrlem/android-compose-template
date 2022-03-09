package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme

@Composable
fun FilmDetailLayout(
    state: FilmDetailState = FilmDetailState(),
    onFavoriteClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    val titleHeight = 160.dp

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .height(titleHeight),
            ) {
                FilmDetailHeader(
                    title = state.title,
                    image = state.image,
                    onBackClick = onBackClick,
                )
            }
        },
    ) {
        FilmDetailContent(
            originalTitle = state.originalTitle,
            originalTitleRomanised = state.originalTitleRomanised,
            summary = state.summary,
            director = state.director,
            releaseDate = state.releaseDate,
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        FloatingActionButton(
            onClick = { onFavoriteClick() },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(y = titleHeight - 32.dp),
        ) {
            Icon(
                painter = painterResource(state.favoriteDrawable),
                tint = state.favoriteColor,
                contentDescription = stringResource(state.favoriteText),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeSampleTheme {
        FilmDetailLayout(
            state = FilmDetailState(
                title = "Le Voyage de Chihiro",
                originalTitle = "千と千尋の神隠し",
                originalTitleRomanised = "Sen to Chihiro no kamikakushi",
                summary = "Le film raconte l'histoire de Chihiro, une fillette de dix ans qui, alors qu'elle se rend en famille vers sa nouvelle maison, entre dans le monde des esprits. Après la transformation de ses parents en porcs par la sorcière Yubaba, Chihiro prend un emploi dans l'établissement de bains de la sorcière pour retrouver ses parents et regagner le monde des humains.",
                director = "Hayao Miyazaki",
                releaseDate = "2001",
            )
        )
    }
}