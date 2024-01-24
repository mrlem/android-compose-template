plugins {
    alias(libs.plugins.app.feature.ui)
}

android {
    namespace = "org.mrlem.sample.compose.features.home.ui"
}

dependencies {
    implementation(project(":features:home:domain"))
}