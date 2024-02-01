import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.mrlem.android.core.gradleplugins.libs

class FeatureNavConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("app.android.library")
                apply("app.android.compose")
                apply("app.android.hilt")
            }

            dependencies {
                add("api", project(":core:feature:nav"))
                add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
                add("implementation", libs.findLibrary("androidx-navigation").get())
                add("implementation", libs.findLibrary("androidx-material3").get())
                add("implementation", libs.findLibrary("javax-inject").get())
                add("implementation", libs.findLibrary("autodagger-android").get())
                add("ksp", libs.findLibrary("autodagger-compiler").get())
            }
        }
    }

}