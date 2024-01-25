import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.mrlem.sample.compose.gradleplugins.libs

class FeatureDataConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("app.android.library")
                apply("app.android.hilt")
            }

            dependencies {
                add("implementation", libs.findLibrary("inject").get())
                add("implementation", libs.findLibrary("autodagger-android").get())
                add("ksp", libs.findLibrary("autodagger-compiler").get())
            }
        }
    }

}