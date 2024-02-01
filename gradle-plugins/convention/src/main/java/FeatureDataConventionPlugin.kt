import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.mrlem.android.core.gradleplugins.libs

class FeatureDataConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("app.android.library")
                apply("app.android.hilt")
            }

            dependencies {
                add("implementation", libs.findLibrary("javax-inject").get())
                add("implementation", libs.findLibrary("autodagger-android").get())
                add("ksp", libs.findLibrary("autodagger-compiler").get())
            }
        }
    }

}