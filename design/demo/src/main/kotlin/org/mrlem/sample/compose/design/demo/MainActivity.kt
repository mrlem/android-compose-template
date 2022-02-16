package org.mrlem.sample.compose.design.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import org.mrlem.sample.compose.design.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        var state by remember { mutableStateOf(0) }

                        TabRow(selectedTabIndex = state) {
                            Tab.values().forEachIndexed { index, tab ->
                                Tab(
                                    text = { Text(stringResource(id = tab.title)) },
                                    selected = state == index,
                                    onClick = { state = index },
                                )
                            }
                        }

                        Tab.values()[state].creator()
                    }
                }
            }
        }
    }

}