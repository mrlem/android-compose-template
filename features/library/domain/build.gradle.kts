plugins {
    alias(libs.plugins.app.feature.domain)
}

android {
    namespace = "org.mrlem.composesample.features.library.domain"
}

dependencies {
    implementation(libs.kotlin.coroutines)
}
