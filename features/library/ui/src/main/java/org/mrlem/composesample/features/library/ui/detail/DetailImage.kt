package org.mrlem.composesample.features.library.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import coil3.compose.AsyncImage

@Composable
fun DetailImage(
    modifier: Modifier = Modifier,
    image: String?,
) {
    var showLoader by remember { mutableStateOf(false) }
    image?.let { image ->
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            onLoading = { showLoader = true },
            onError = { showLoader = false },
            onSuccess = { showLoader = false },
            modifier = modifier,
        )
    }

    val localInspectionMode = LocalInspectionMode.current
    if (showLoader || localInspectionMode) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    }
}
