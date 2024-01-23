@file:Suppress("UnstableApiUsage")

plugins {
    `kotlin-dsl`
}

group = "org.mrlem.sample.compose.gradleplugins"

java {
    toolchain {
        // This sets the JVM version needed to build this project.
        // Notice that we set this version in the Version Catalog, and we can use it here!
        languageVersion.set(JavaLanguageVersion.of(libs.versions.jvm.get().toString()))
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
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
        register("androidLibrary") {
            id = "app.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "app.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
    }
}