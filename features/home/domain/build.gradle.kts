plugins {
    alias(libs.plugins.app.feature.domain)
}

android {
    namespace = "org.mrlem.sample.compose.features.home.domain"
}

dependencies {
    implementation(libs.kotlin.coroutines)
}