plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.AndroidX.lifecycle}")

    api("com.jakewharton.timber:timber:${Versions.timber}")
}