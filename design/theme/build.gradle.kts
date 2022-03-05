import extensions.compose

plugins {
    id("com.android.library")
    kotlin("android")
}

compose()

dependencies {
    implementation("androidx.compose.material:material:${Versions.compose}")
    implementation("com.google.android.material:material:${Versions.material}")
}