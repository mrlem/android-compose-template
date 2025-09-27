plugins {
    `kotlin-dsl`
}

group = "org.mrlem.android.core.gradleplugins"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    api(libs.room.gradle.plugin)
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
        register("androidCompose") {
            id = "app.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "app.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "app.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("featureUi") {
            id = "app.feature.ui"
            implementationClass = "FeatureUiConventionPlugin"
        }
        register("featureDomain") {
            id = "app.feature.domain"
            implementationClass = "FeatureDomainConventionPlugin"
        }
        register("featureData") {
            id = "app.feature.data"
            implementationClass = "FeatureDataConventionPlugin"
        }
        register("featureNav") {
            id = "app.feature.nav"
            implementationClass = "FeatureNavConventionPlugin"
        }
    }
}