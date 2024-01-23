plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
}

android {
    namespace = "org.mrlem.sample.compose.features.home.ui"
}

dependencies {
    implementation(project(":core:ui:theme"))
    implementation(libs.lifecycle.viewmodel.compose)
}