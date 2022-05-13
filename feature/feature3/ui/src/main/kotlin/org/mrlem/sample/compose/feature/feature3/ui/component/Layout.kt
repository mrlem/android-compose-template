package org.mrlem.sample.compose.feature.feature3.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.feature.feature3.ui.FilmDetailViewState

@Composable
internal fun Layout(
    state: FilmDetailViewState,
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
                Header(
                    title = state.title,
                    image = state.image,
                    onBackClick = onBackClick,
                )
            }
        },
    ) {
        Infos(
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
        Favorite(
            state = state.favoriteState,
            onFavoriteClick = onFavoriteClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(y = titleHeight - 32.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeSampleTheme {
        Layout(
            state = FilmDetailViewState(
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