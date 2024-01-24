plugins {
    alias(libs.plugins.app.android.library)
}

android {
    namespace = "org.mrlem.sample.compose.core.ui.base"
}

dependencies {
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.kotlin.coroutines)
}