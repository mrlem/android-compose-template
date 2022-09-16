plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(project(":arch:domain"))
}
android {
    namespace = "org.mrlem.sample.compose.feature.ghibli.domain"
}
