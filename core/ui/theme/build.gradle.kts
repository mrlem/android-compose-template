plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
}

android {
    namespace = "org.mrlem.sample.compose.core.ui.theme"
}

dependencies {
    implementation(libs.core.ktx)
}