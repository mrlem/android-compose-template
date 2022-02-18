import extensions.room

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

room()

dependencies {
    implementation(project(":feature:greeting:domain"))

    implementation("com.google.dagger:hilt-android:${Versions.hilt}")

    kapt("com.google.dagger:hilt-android-compiler:${Versions.hilt}")
}