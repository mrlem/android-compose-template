plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
}

android {
    namespace = "org.mrlem.composesample.theme"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}