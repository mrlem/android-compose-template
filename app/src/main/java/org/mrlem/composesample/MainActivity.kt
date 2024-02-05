package org.mrlem.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import org.mrlem.android.core.feature.nav.BottomNavProvider
import org.mrlem.android.core.feature.ui.NavProvider
import org.mrlem.composesample.theme.Theme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navProviders: Set<@JvmSuppressWildcards NavProvider>

    @Inject
    lateinit var bottomNavProviders: Set<@JvmSuppressWildcards BottomNavProvider>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    MainWindow(
                        navProviders = navProviders,
                        bottomNavProviders = bottomNavProviders,
                    )
                }
            }
        }
    }

}