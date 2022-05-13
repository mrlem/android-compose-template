plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(project(":arch:domain"))
}