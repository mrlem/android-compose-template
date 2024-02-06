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
            }

            dependencies {
                add("api", project(":core:feature:nav"))
                add("implementation", libs.findLibrary("androidx-navigation").get())
            }
        }
    }

}