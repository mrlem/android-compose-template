plugins {
    alias(libs.plugins.app.feature.data)
    alias(libs.plugins.app.android.room)
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode")
    }
}

android {
    namespace = "org.mrlem.composesample.features.library.data"
}

dependencies {
    implementation(project(":core:di"))
    implementation(project(":features:library:domain"))
    implementation(libs.kotlin.coroutines)
    implementation(libs.bundles.retrofit)

    ksp(libs.retrofit.moshi.codegen)
}
