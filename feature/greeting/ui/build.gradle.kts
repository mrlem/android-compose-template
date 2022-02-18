import extensions.compose
import extensions.hilt

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

compose()
hilt()

dependencies {
    implementation(project(":arch:ui"))
    implementation(project(":feature:greeting:domain"))
}