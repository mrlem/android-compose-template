plugins {
    alias(libs.plugins.app.android.library)
}

android {
    namespace = "org.mrlem.android.core.di"
}

dependencies {
    implementation(libs.javax.inject)
}