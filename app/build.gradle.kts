import extensions.compose
import extensions.hilt
import extensions.room

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    defaultConfig {
        applicationId = "org.mrlem.sample.compose"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

compose()
hilt()
room()

dependencies {
    implementation(project(":design:theme"))
    // new features
    implementation(project(":feature:filmslist:ui"))
    implementation(project(":feature:filmdetail:ui"))
    implementation(project(":feature:favorites:data"))
    implementation(project(":feature:ghibli:data"))

    implementation("androidx.activity:activity-compose:${Versions.AndroidX.activity}")
    implementation("androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}")
    implementation("androidx.core:core-ktx:${Versions.AndroidX.core}")
    implementation("androidx.navigation:navigation-compose:${Versions.AndroidX.navigation}")

    testImplementation("junit:junit:${Versions.junit}")

    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.AndroidX.Test.espresso}")
    androidTestImplementation("androidx.test.ext:junit:${Versions.AndroidX.Test.junit}")
}