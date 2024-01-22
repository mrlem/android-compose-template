@file:Suppress("UnstableApiUsage")

plugins {
    `kotlin-dsl`
}

group = "org.mrlem.sample.compose.gradleplugins"

java {
    toolchain {
        // This sets the JVM version needed to build this project.
        // Notice that we set this version in the Version Catalog, and we can use it here!
        languageVersion.set(JavaLanguageVersion.of(libs.versions.jvm.get()))
    }
}

dependencies {
//    compileOnly(libs.android.gradlePlugin)
//    compileOnly(libs.android.tools.common)
//    compileOnly(libs.firebase.crashlytics.gradlePlugin)
//    compileOnly(libs.firebase.performance.gradlePlugin)
//    compileOnly(libs.kotlin.gradlePlugin)
//    compileOnly(libs.ksp.gradlePlugin)
//    compileOnly(libs.room.gradlePlugin)
//    implementation(libs.truth)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "app.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}