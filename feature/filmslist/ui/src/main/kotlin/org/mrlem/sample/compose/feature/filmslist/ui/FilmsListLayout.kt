package org.mrlem.sample.compose.feature.filmslist.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme

@Composable
fun FilmsListLayout(
    state: FilmsListState = FilmsListState(),
    onClick: () -> Unit = {},
) {
    // TODO - implement as a LazyColumn of films

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .align(Alignment.Center),
        ) {
            Text(text = "Go to film!")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeSampleTheme {
        FilmsListLayout()
    }
}