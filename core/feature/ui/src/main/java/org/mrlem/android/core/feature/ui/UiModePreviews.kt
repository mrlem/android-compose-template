package org.mrlem.android.core.feature.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Day",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
annotation class UiModePreviews