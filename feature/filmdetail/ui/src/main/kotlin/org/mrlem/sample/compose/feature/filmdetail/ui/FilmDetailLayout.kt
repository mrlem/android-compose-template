package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme
import org.mrlem.sample.compose.design.theme.Typography

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
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    AsyncImage(
                        model = state.image.toString(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize(),
                    )

                    Text(
                        text = state.title,
                        style = Typography.subtitle1,
                        modifier = Modifier
                            .padding(32.dp)
                            .align(Alignment.BottomCenter),
                    )

                    IconButton(
                        onClick = { onBackClick() },
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .align(Alignment.TopStart),
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back),
                            contentDescription = stringResource(R.string.filmdetail_back),
                        )
                    }
                }
            }
        },
    ) {

        val scrollableState = rememberScrollState()

        Column(
            modifier = Modifier
                .verticalScroll(scrollableState)
                .padding(16.dp)
                .fillMaxSize(),
        ) {

            Text(
                text = state.originalTitle,
                color = Color.LightGray,
                style = Typography.caption,
            )
            Text(
                text = state.originalTitleRomanised,
                color = Color.LightGray,
                style = Typography.caption,
            )

            Text(
                text = stringResource(R.string.filmdetail_summary),
                color = Color.DarkGray,
                style = Typography.subtitle2,
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
            Row(
                modifier = Modifier
                    .padding(top = 16.dp),
            ) {
                Text(
                    text = stringResource(R.string.filmdetail_date),
                    style = Typography.body1,
                )
                Text(
                    text = state.releaseDate,
                    style = Typography.body2,
                    modifier = Modifier
                        .padding(start = 4.dp),
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 4.dp),
            ) {
                Text(
                    text = stringResource(R.string.filmdetail_director),
                    style = Typography.body1,
                )
                Text(
                    text = state.director,
                    style = Typography.body2,
                    modifier = Modifier
                        .padding(start = 4.dp),
                )
            }
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
                director = "Hayao Miyazaki",
                releaseDate = "2001",
            )
        )
    }
}