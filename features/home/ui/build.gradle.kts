plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
    alias(libs.plugins.app.android.hilt)
}

android {
    namespace = "org.mrlem.sample.compose.features.home.ui"
}

dependencies {
    implementation(project(":core:arch:ui"))
    implementation(project(":core:ui:theme"))
    implementation(project(":features:home:domain"))
    implementation(libs.lifecycle.viewmodel.compose)
}