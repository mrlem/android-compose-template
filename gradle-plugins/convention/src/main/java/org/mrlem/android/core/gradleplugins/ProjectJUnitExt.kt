package org.mrlem.android.core.gradleplugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureJUnit() {
    dependencies {
        add("testImplementation", libs.findLibrary("junit").get())
    }
}