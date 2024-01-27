plugins {
    alias(libs.plugins.app.feature.data)
}

android {
    namespace = "org.mrlem.sample.compose.features.library.data"
}

dependencies {
    implementation(project(":features:library:domain"))
    implementation(libs.kotlin.coroutines)
}
