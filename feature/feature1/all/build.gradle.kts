import extensions.hilt
import extensions.room

plugins {
    id("com.android.library")
    kotlin("android")
}

hilt()
room()

dependencies {
    implementation(project(":arch:data"))
    implementation(project(":arch:domain"))

    api("com.squareup.retrofit2:retrofit:${Versions.retrofit}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofit}")
}
