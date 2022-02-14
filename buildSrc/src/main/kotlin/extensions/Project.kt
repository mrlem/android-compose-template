package extensions

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.plugins.AppPlugin
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

private fun Project.androidLibrary(configure: Action<LibraryExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("android", configure)

private fun Project.androidApplication(configure: Action<ApplicationExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("android", configure)

private val Project.kapt: KaptExtension get() =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.getByName("kapt") as KaptExtension

private fun Project.kapt(configure: Action<KaptExtension>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("kapt", configure)

fun Project.compose(isHiltEnabled: Boolean = false) {
    if (plugins.hasPlugin(AppPlugin::class.java)) {
        androidApplication {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Versions.compose
            }
        }
    } else {
        androidLibrary {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Versions.compose
            }
        }
    }

    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }

    dependencies {
        add("implementation", "androidx.compose.material:material:${Versions.compose}")
        add("implementation", "androidx.compose.ui:ui:${Versions.compose}")
        add("implementation", "androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
        add("implementation", "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-alpha02")

        add("debugImplementation", "androidx.compose.ui:ui-tooling:${Versions.compose}")

        add("androidTestImplementation", "androidx.compose.ui:ui-test-junit4:${Versions.compose}")

        if (isHiltEnabled) {
            add("api", "com.google.dagger:hilt-android:${Versions.hilt}")
            add("kapt", "com.google.dagger:hilt-android-compiler:${Versions.hilt}")
            // FIXME - should work like this
//            api("com.google.dagger:hilt-android:${Versions.hilt}")
//            kapt("com.google.dagger:hilt-android-compiler:${Versions.hilt}")
        }
    }
}