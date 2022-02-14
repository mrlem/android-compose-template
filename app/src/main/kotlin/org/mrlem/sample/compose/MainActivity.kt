package org.mrlem.sample.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import org.mrlem.sample.compose.feature.greeting.ui.GreetingScreen
import org.mrlem.sample.compose.ui.theme.ComposeSampleTheme

// TODO - components: that's where the design system goes: externalize
// TODO - view model: isolation per composable
// TODO - view model: lifecycle callbacks

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GreetingScreen()
                }
            }
        }
    }

}