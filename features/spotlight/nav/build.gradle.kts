plugins {
    alias(libs.plugins.app.feature.nav)
}

android {
    namespace = "org.mrlem.sample.compose.features.spotlight.nav"
}

dependencies {
    api(project(":core:feature:nav"))
}