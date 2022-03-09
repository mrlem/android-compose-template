package org.mrlem.sample.compose.feature.filmdetail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.mrlem.sample.compose.design.theme.Typography

@Composable
fun FilmDetailHeader(
    title: String,
    image: String?,
    onBackClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AsyncImage(
            model = image.toString(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
        )

        Text(
            text = title,
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