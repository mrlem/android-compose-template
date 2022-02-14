import extensions.compose

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

compose(isHiltEnabled = true)

dependencies {
    implementation(project(":arch:ui"))
    implementation(project(":feature:greeting:domain"))
}