import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.mrlem.sample.compose.gradleplugins.commonExtension
import org.mrlem.sample.compose.gradleplugins.configureKotlin
import org.mrlem.sample.compose.gradleplugins.configureKotlinAndroid

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            commonExtension.apply {
                configureKotlin()
                configureKotlinAndroid(this)
                dependencies {
                    add("implementation", project(":core:feature:ui"))
                }
            }
        }
    }

}