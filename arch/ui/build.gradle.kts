import extensions.compose

plugins {
    id("com.android.library")
    kotlin("android")
}

compose()

dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.AndroidX.lifecycle}")
    implementation("androidx.navigation:navigation-compose:${Versions.AndroidX.navigation}")

    implementation("com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}")
}
android {
    namespace = "org.mrlem.sample.compose.arch.ui"
}
