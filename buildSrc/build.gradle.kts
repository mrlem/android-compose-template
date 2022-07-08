plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin","1.7.0"))
    implementation("com.android.tools.build:gradle:7.1.3")
    implementation("com.squareup:javapoet:1.13.0") // FIXME https://github.com/google/dagger/issues/3068
}