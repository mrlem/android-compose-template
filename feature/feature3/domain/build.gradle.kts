plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    api(project(":arch:domain"))
    implementation(project(":feature:feature1:domain"))
}