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
    implementation(project(":design:theme"))
    implementation(project(":feature:ghibli:domain"))

    implementation("io.coil-kt:coil:${Versions.coil}")
    implementation("io.coil-kt:coil-compose:${Versions.coil}")
}
