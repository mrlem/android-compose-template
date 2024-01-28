plugins {
    alias(libs.plugins.app.android.library)
}

android {
    namespace = "org.mrlem.sample.compose.core.feature.nav"
}

dependencies {
    implementation(libs.androidx.navigation)
}