plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
}

android {
    namespace = "org.mrlem.android.core.feature.ui"
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.kotlin.coroutines)
}
