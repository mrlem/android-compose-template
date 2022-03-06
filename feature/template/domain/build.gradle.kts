plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    implementation(project(":arch:domain"))
}