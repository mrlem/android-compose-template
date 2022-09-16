package org.mrlem.sample.compose.feature.filmdetail.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.mrlem.sample.compose.design.theme.Typography
import org.mrlem.sample.compose.feature.filmdetail.ui.R

@Composable
internal fun Infos(
    originalTitle: String,
    originalTitleRomanised: String,
    summary: String,
    director: String,
    releaseDate: String,
    modifier: Modifier = Modifier,
) {
    val scrollableState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollableState)
            .padding(16.dp)
            .fillMaxSize(),
    ) {

        Text(
            text = originalTitle,
            color = Color.LightGray,
            style = Typography.caption,
        )
        Text(
            text = originalTitleRomanised,
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
            text = summary,
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
                text = releaseDate,
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
                text = director,
                style = Typography.body2,
                modifier = Modifier
                    .padding(start = 4.dp),
            )
        }
    }
}