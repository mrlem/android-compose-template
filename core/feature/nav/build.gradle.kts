plugins {
    alias(libs.plugins.app.android.library)
}

android {
    namespace = "org.mrlem.android.core.feature.nav"
}

dependencies {
    implementation(libs.androidx.navigation)
}