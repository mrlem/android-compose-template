import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.mrlem.android.core.gradleplugins.libs

class FeatureUiConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("app.android.library")
                apply("app.android.compose")
                apply("app.android.hilt")
            }

            dependencies {
                add("implementation", project(":core:feature:ui"))
                add("implementation", libs.findLibrary("androidx-lifecycle-viewmodel-compose").get())
                add("implementation", libs.findLibrary("androidx.hilt.navigation").get())
                add("implementation", libs.findLibrary("autodagger-android").get())
                add("ksp", libs.findLibrary("autodagger-compiler").get())
            }
        }
    }

}