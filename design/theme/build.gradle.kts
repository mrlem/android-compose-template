import extensions.compose

plugins {
    id("com.android.library")
    kotlin("android")
}

compose()

dependencies {
    implementation("androidx.compose.material:material:${Versions.Compose.compose}")
    implementation("com.google.android.material:material:${Versions.material}")
}
android {
    namespace = "org.mrlem.sample.compose.design.theme"
}
