import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.mrlem.android.core.gradleplugins.applicationExtension
import org.mrlem.android.core.gradleplugins.configureJUnit
import org.mrlem.android.core.gradleplugins.configureKotlin
import org.mrlem.android.core.gradleplugins.configureKotlinAndroid

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            requireNotNull(applicationExtension).apply {
                buildFeatures {
                    buildConfig = true
                }

                configureKotlin()
                configureKotlinAndroid(this)
            }

            dependencies {
                add("implementation", project(":core:feature:ui"))
                add("implementation", project(":core:feature:nav"))
            }
            configureJUnit()
        }
    }

}