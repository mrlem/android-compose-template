plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api("com.jakewharton.timber:timber:${Versions.timber}")
    api("javax.inject:javax.inject:${Versions.Javax.inject}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.coroutines}")
}