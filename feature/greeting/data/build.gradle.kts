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
    implementation(project(":feature:greeting:domain"))
}