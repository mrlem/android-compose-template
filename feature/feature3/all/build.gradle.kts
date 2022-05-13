import extensions.compose
import extensions.hilt
import extensions.room

plugins {
    id("com.android.library")
    kotlin("android")
}

compose()
hilt()
room()

dependencies {
    implementation(project(":arch:ui"))
    implementation(project(":arch:data"))
    implementation(project(":arch:domain"))
    implementation(project(":design:theme"))
    implementation(project(":feature:feature1:all"))

    implementation("io.coil-kt:coil:${Versions.coil}")
    implementation("io.coil-kt:coil-compose:${Versions.coil}")

    api("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
}
