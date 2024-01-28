plugins {
    alias(libs.plugins.app.feature.ui)
}

android {
    namespace = "org.mrlem.sample.compose.features.library.ui"
}

dependencies {
    implementation(project(":features:library:domain"))
    implementation(project(":features:library:nav"))
}
