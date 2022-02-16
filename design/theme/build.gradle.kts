import extensions.compose

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

compose()

dependencies {
    implementation("androidx.compose.material:material:${Versions.compose}")
}