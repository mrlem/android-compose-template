package org.mrlem.sample.compose.gradleplugins

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.plugins.PluginInstantiationException
import org.gradle.kotlin.dsl.findByType

val Project.commonExtension: CommonExtension<*, *, *, *, *>
    get() = extensions.run {
        findByType<ApplicationExtension>()
            ?: findByType<com.android.build.api.dsl.LibraryExtension>()
            ?: throw PluginInstantiationException("Can only be applied on an android Application or Library")
    }