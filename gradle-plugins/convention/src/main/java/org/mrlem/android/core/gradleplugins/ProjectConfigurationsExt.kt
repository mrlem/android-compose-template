package org.mrlem.android.core.gradleplugins

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal val Project.libs: VersionCatalog
    get() = versionCatalogsExtension.named("libs")

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(libs.findVersion("jvm").get().toString()))
            freeCompilerArgs.set(listOf("-XXLanguage:+PropertyParamAnnotationDefaultTargetMode"))
        }
    }
}

internal fun Project.configureKotlinAndroid() {
    commonExtension.apply {
        compileSdk = libs.findVersion("compile-sdk").get().toString().toInt()

        defaultConfig {
            minSdk = libs.findVersion("min-sdk").get().toString().toInt()
        }

        compileOptions {
            val javaVersion = JavaVersion.toVersion(libs.findVersion("jvm").get())
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }

        dependencies {
            add("implementation", libs.findLibrary("timber").get())
        }
    }
}

internal fun Project.configureAndroidCompose() {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()

        add("implementation", platform(bom))
        add("androidTestImplementation", platform(bom))

        add("implementation", libs.findLibrary("androidx-ui").get())
        add("implementation", libs.findLibrary("androidx-ui-graphics").get())
        add("implementation", libs.findLibrary("androidx.material.icons").get())
        add("implementation", libs.findLibrary("androidx-material3").get())
        add("implementation", libs.findLibrary("androidx-ui-tooling-preview").get())
        add("debugImplementation", libs.findLibrary("androidx-ui-tooling").get())
    }
}

internal fun Project.configureJUnit() {
    dependencies {
        add("testImplementation", libs.findLibrary("junit").get())
    }
}