plugins {
    alias(libs.plugins.app.feature.data)
    alias(libs.plugins.app.android.room)
}

android {
    namespace = "org.mrlem.sample.compose.features.library.data"
}

dependencies {
    implementation(project(":features:library:domain"))
    implementation(libs.kotlin.coroutines)
    implementation(libs.bundles.retrofit)
}
