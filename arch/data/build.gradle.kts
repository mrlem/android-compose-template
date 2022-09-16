plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api("javax.inject:javax.inject:${Versions.Javax.inject}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.coroutines}")
}
android {
    namespace = "org.mrlem.sample.compose.arch.data"
}
