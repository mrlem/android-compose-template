plugins {
    alias(libs.plugins.app.feature.ui)
}

android {
    namespace = "org.mrlem.sample.compose.features.spotlight.ui"
}

dependencies {
    implementation(project(":features:spotlight:nav"))
    implementation(project(":features:library:domain"))
    implementation(project(":features:library:nav"))
}