package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.design.theme.Typography

@Composable
fun FilmDetailLayout(
    state: FilmDetailState = FilmDetailState(),
    onFavoriteClick: () -> Unit = {},
) {
    val titleHeight = 160.dp

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .padding(32.dp)
                            .fillMaxSize(),
                    ) {
                        Text(
                            text = state.title,
                            modifier = Modifier
                                .align(Alignment.BottomCenter),
                        )
                    }
                },
                modifier = Modifier
                    .height(titleHeight),
            )
        },
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = state.originalTitle,
                color = Color.LightGray,
                style = Typography.body2,
            )
            Text(
                text = state.originalTitleRomanised,
                color = Color.LightGray,
                style = Typography.body2,
            )

            Text(
                text = stringResource(R.string.filmdetail_summary),
                color = Color.DarkGray,
                style = Typography.h6,
                modifier = Modifier
                    .padding(top = 16.dp),
            )
            Text(
                text = state.summary,
                textAlign = TextAlign.Justify,
                color = Color.DarkGray,
                style = Typography.body2,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
            )
        }
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
                .padding(top = titleHeight - 32.dp),
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
            )
        )
    }
}