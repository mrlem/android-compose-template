package org.mrlem.sample.compose.design.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mrlem.sample.compose.design.theme.Typography

@Composable
fun TypographyTab() {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = "subtitle1",
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                )
                Text(
                    text = "The quick brown fox jumps over the lazy dog",
                    style = Typography.subtitle1,
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = "subtitle2",
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                )
                Text(
                    text = "The quick brown fox jumps over the lazy dog",
                    style = Typography.subtitle2,
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = "body1",
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                )
                Text(
                    text = "The quick brown fox jumps over the lazy dog",
                    style = Typography.body1,
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
            ) {
                Text(
                    text = "caption",
                    fontSize = 12.sp,
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                )
                Text(
                    text = "The quick brown fox jumps over the lazy dog",
                    style = Typography.caption,
                )
            }
        }
    }
}