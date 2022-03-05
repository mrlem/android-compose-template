plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin","1.6.10"))
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation("com.squareup:javapoet:1.13.0") // FIXME https://github.com/google/dagger/issues/3068
}