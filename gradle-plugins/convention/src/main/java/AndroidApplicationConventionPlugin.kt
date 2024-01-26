import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project
import org.mrlem.sample.compose.gradleplugins.configureKotlin
import org.mrlem.sample.compose.gradleplugins.configureKotlinAndroid

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.getByType<ApplicationExtension>().apply {
                configureKotlin()
                configureKotlinAndroid(this)
                dependencies {
                    add("implementation", project(":core:feature:ui"))
                }
            }
        }
    }
}