plugins {
    alias(libs.plugins.app.feature.data)
}

android {
    namespace = "org.mrlem.sample.compose.features.home.data"
}

dependencies {
    implementation(project(":features:home:domain"))
    implementation(libs.kotlin.coroutines)
}