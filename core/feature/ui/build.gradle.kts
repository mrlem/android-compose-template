plugins {
    alias(libs.plugins.app.android.library)
    alias(libs.plugins.app.android.compose)
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
}

android {
    namespace = "org.mrlem.android.core.feature.ui"
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.kotlin.coroutines)
}