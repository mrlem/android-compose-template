package org.mrlem.composesample.features.library.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import org.mrlem.android.core.feature.ui.UiModePreviews
import org.mrlem.composesample.features.library.ui.R
import org.mrlem.composesample.theme.Theme

@Composable
internal fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Detail(
        state = state,
    )
}

@Composable
private fun Detail(state: DetailViewState) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(
            text = state.name,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Theme.size.larger,
                    horizontal = Theme.size.medium,
                ),
        )

        val context = LocalContext.current
        val imageLoader = remember {
            ImageLoader.Builder(context)
                .components {
                    add(
                        OkHttpNetworkFetcherFactory(
                            callFactory = {
                                OkHttpClient.Builder()
                                    .addInterceptor { chain ->
                                        val originRequest = chain.request()
                                        val requestWithUserAgent: Request = originRequest.newBuilder()
                                            .header("User-Agent", "ComposeSample/1.0 (https://github.com/mrlem/android-compose-template)")
                                            .build()
                                        chain.proceed(requestWithUserAgent)
                                    }
                                    .build()
                            }
                        )
                    )
                }
                .build()
        }
        state.image?.let { image ->
            var showLoader by remember { mutableStateOf(false) }

            AsyncImage(
                model = image,
                imageLoader = imageLoader,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                onLoading = { showLoader = true },
                onError = { showLoader = false },
                onSuccess = { showLoader = false },
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally),
            )

            if (showLoader) {
                Box(
                    modifier = Modifier
                        .size(250.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@UiModePreviews
@Composable
private fun Preview() {
    Theme {
        Surface {
            Detail(
                state = DetailViewState(
                    name = "Saturn",
                ),
            )
        }
    }
}