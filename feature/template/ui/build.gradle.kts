import extensions.compose
import extensions.hilt

plugins {
    id("com.android.library")
    kotlin("android")
}

compose()
hilt()

dependencies {
    implementation(project(":arch:ui"))
    implementation(project(":feature:NAME:domain"))
}
